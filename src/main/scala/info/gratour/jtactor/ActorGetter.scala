/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jtactor

import java.util.concurrent.atomic.AtomicReference

import akka.actor.ActorRef
import com.typesafe.scalalogging.Logger

trait ActorGetter {

  import ActorGetter.logger

  def get: ActorRef

  def tell(msg: Object): Unit = {
    val actor = get
    if (actor != null)
      actor ! msg
    else
      logger.warn(s"Actor does not available for send: ${msg.getClass.getSimpleName}")
  }

  def tell(msg: Object, sender: ActorRef): Unit = {
    val actor = get
    if (actor != null)
      actor.tell(msg, sender)
    else
      logger.warn(s"Actor does not available for send: ${msg.getClass.getSimpleName}")
  }
}

case class DirectActorGetter(actorRef: ActorRef) extends ActorGetter {
  override def get: ActorRef = actorRef
}

case class AtomicReferenceActorGetter(ref: AtomicReference[ActorRef]) extends ActorGetter {

  override def get: ActorRef = ref.get()

  def set(actorRef: ActorRef): Unit = ref.set(actorRef)
}

object ActorGetter {
  private val logger = Logger[AtomicReferenceActorGetter]
}
