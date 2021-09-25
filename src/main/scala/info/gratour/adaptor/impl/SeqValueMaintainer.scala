package info.gratour.adaptor.impl

import akka.actor.{Actor, Props, Timers}
import com.typesafe.scalalogging.Logger
import info.gratour.adaptor.SysRepo

import scala.concurrent.duration
import scala.concurrent.duration.Duration

class SeqValueMaintainer(sysRepo: SysRepo) extends Actor with Timers {

  import SeqValueMaintainer.logger

  private def putNewSegment(provider: SeqValueProviderImpl): Boolean = {
    val config = provider.config

    try {
      val v = sysRepo.nextSeqValue(config.seqName)
      val segment = new SeqValueSegment(config, v)
      provider.put(segment)

      logger.whenDebugEnabled {
        logger.debug(s"Fetch next segment for ${config.seqName} successfully.")
      }

      true
    } catch {
      case t: Throwable =>
        logger.whenDebugEnabled {
          logger.error(s"Error occurred when fetch next segment for ${config.seqName}.", t)
        }
        false
    }
  }

  private var maintaining = false

  private def updateNewSegmentFor(provider: SeqValueProviderImpl): Unit = {
    if (putNewSegment(provider))
      maintaining = false
    else
      timers.startSingleTimer(SeqValueMaintainer.RetryTimerKey, SeqValueMaintainer.Retry(provider), Duration(5, duration.SECONDS))
  }

  override def receive: Receive = {
    case SeqValueMaintainReq(provider) =>
      if (!maintaining) {
        maintaining = true
        updateNewSegmentFor(provider)
      }

    case SeqValueMaintainer.Retry(provider) =>
      updateNewSegmentFor(provider)
  }

}

object SeqValueMaintainer {
  private val logger = Logger[SeqValueMaintainer]

  def props(sysRepo: SysRepo): Props =
    Props(new SeqValueMaintainer(sysRepo))

  private case object RetryTimerKey

  private case class Retry(provider: SeqValueProviderImpl)

}
