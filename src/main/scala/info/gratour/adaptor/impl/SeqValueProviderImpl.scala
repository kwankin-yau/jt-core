/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.impl

import java.util.concurrent.{ArrayBlockingQueue, TimeUnit}

import akka.actor.ActorRef
import com.typesafe.scalalogging.Logger
import info.gratour.adaptor.{SeqValueProvider, SysRepo}

class SeqValueProviderImpl(val config: SeqValueConfig, init: SeqValueSegment, maintainer: ActorRef) extends SeqValueProvider {

  private val segmentQueue = new ArrayBlockingQueue[SeqValueSegment](2)
  segmentQueue.offer(init)

  private var currSegment: SeqValueSegment = _

  override def tryGet(): Long = {
    synchronized {
      if (currSegment == null) {
        currSegment = segmentQueue.poll(5, TimeUnit.SECONDS)
        if (currSegment == null)
          return 0
      }

      val opt = currSegment.get
      val value =
        if (opt.isEmpty) {
          currSegment = segmentQueue.poll(5, TimeUnit.SECONDS)
          if (currSegment == null)
            return 0

          currSegment.get.get
        } else
          opt.get

      if (value == currSegment.threshold)
        maintainer ! SeqValueMaintainReq(this)

      value
    }
  }

  def put(seqValueSegment: SeqValueSegment): Unit =
    segmentQueue.put(seqValueSegment)

}

object SeqValueProviderImpl {
  private val logger = Logger[SeqValueProviderImpl]

  private def getInitSeqValueSegment(sysRepository: SysRepo, config: SeqValueConfig): SeqValueSegment = {

    val v = sysRepository.nextSeqValue(config.seqName)
    val r = new SeqValueSegment(config, v)

    logger.whenDebugEnabled {
      logger.debug(s"Fetch initialize seq value $config successfully.")
    }

    r
  }

  def create(sysRepository: SysRepo, seqValueConfig: SeqValueConfig, seqValueMaintainer: ActorRef): SeqValueProvider = {
    val segment = getInitSeqValueSegment(sysRepository, seqValueConfig)
    new SeqValueProviderImpl(seqValueConfig, segment, seqValueMaintainer)
  }

}

case class SeqValueConfig(seqName: String, incr: Int)

object SeqValueConfig {

  val SeqValueConfigTrkId: SeqValueConfig = SeqValueConfig(SeqValueProvider.SEQ_TRK_ID, 100000)
  val SeqValueConfigAlmId: SeqValueConfig = SeqValueConfig(SeqValueProvider.SEQ_ALM_ID, 15000)
  val SeqValueConfigGovIssueId: SeqValueConfig = SeqValueConfig(SeqValueProvider.SEQ_GOV_ISSUE_ID, 10000)
//  val SeqValueConfigTermCmdId: SeqValueConfig = SeqValueConfig(SeqValueProvider.SEQ)
}

class SeqValueSegment(val config: SeqValueConfig, val start: Long) {
  private var curr: Long = start
  private val next: Long = start + config.incr
  val threshold: Long = next - (next - start) / 4

  def get: Option[Long] = {
    if (curr == next)
      return None

    val r = curr
    curr += 1

    Some(r)
  }
}

case class SeqValueMaintainReq(seqValueProvider: SeqValueProviderImpl)
