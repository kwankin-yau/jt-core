/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.adaptor.mq

import java.util

import akka.actor.{Actor, Props}
import com.typesafe.scalalogging.Logger
import javax.jms.{Connection, ConnectionFactory, Destination, MessageProducer, Queue, Session, Topic}

class AkkaMQSender(connectionFactory: ConnectionFactory) extends Actor {

  import AkkaMQSender.logger

  private var conn: Connection = _
  private var session: Session = _
  private var producer: MessageProducer = _

  private val topics: java.util.Map[String, Destination] = new util.HashMap[String, Destination]()
  private val queues: java.util.Map[String, Destination] = new util.HashMap[String, Destination]()

  override def preStart(): Unit = {
    conn = connectionFactory.createConnection()
    conn.start()

    session = conn.createSession(false, Session.DUPS_OK_ACKNOWLEDGE)
    producer = session.createProducer(null)
  }


  override def postStop(): Unit = {
    if (producer != null) {
      producer.close()
      producer = null
    }

    if (session != null) {
      session.close()
      session = null
    }

    if (conn != null) {
      conn.close()
      conn = null
    }
  }

  private def getDestination(isTopic: Boolean, name: String): Destination = {
    val map =
      if (isTopic)
        topics
      else
        queues

    var d = map.get(name)
    if (d == null) {
      if (isTopic)
        d = session.createTopic(name)
      else
        d = session.createQueue(name)

      map.put(name, d)
    }

    d
  }

  private def sendText(isTopic: Boolean, name: String, message: String, typ: String): Unit = {
    val msg = session.createTextMessage(message)
    if (typ != null)
      msg.setStringProperty("typ", typ)

    producer.send(getDestination(isTopic = true, name), msg)
    logger.debug(s"SEND TO Topic <<${name}>>: " + message)
  }

  override def receive: Receive = {
    case m: AkkaMQSender.SendTextToTopic =>
      sendText(isTopic = true, m.topic, m.message, m.typ)

    case m: AkkaMQSender.SendMsgToTopic =>
      val message = MQ_JSON.toJson(m.message)
      sendText(isTopic = true, m.topic, message, m.typ)
  }
}

object AkkaMQSender {

  private val logger = Logger("AkkaMQSender")

  case class SendTextToTopic(topic: String, message: String, typ: String)
  case class SendMsgToTopic(topic: String, message: Object, typ: String)

  def props(connectionFactory: ConnectionFactory): Props = Props(new AkkaMQSender(connectionFactory))
}
