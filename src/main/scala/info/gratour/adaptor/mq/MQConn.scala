/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.adaptor.mq

import java.io.Closeable

import com.google.gson.Gson
import com.typesafe.scalalogging.Logger
import info.gratour.adaptor.mq.dto.gateway.{GatewayReq, GatewayResp}
import info.gratour.adaptor.mq.dto.{DataChangeEvent, RtRgnChange, StrmMediaNotif}
import info.gratour.gnss.core.strmmediaapi.StrmMediaApi
import info.gratour.jtmodel.TermCmd
import info.gratour.jtmodel.govissue.{GovIssueAckMsg, GovIssueMsg}
import info.gratour.jtmodel.govsubmit.GovSubmitMsg
import javax.jms._

trait MQConnProvider {
  def getConn: Connection
}

/**
 * Used for consumer
 *
 * @param connectionFactory underlying connection factory
 */
class MQConsumerConnHub(connectionFactory: ConnectionFactory) extends MQConnProvider {

  private lazy val conn: Connection = {
    val r = connectionFactory.createConnection()
    r.start()
    r
  }

  override def getConn: Connection = conn
}

object MQConsumerConnHub {
  def apply(connectionFactory: ConnectionFactory): MQConsumerConnHub = new MQConsumerConnHub(connectionFactory)
}

/**
 * Used for sender
 *
 * @param connectionFactory
 */
case class MQConnFactory(connectionFactory: ConnectionFactory) extends MQConnProvider {
  override def getConn: Connection = connectionFactory.createConnection()
}

//trait MQConn extends MQConnProvider {
//
//  def connParams: ConnParams
//
//  def createConnFactory(): ConnectionFactory
//
//  protected def createConn: Connection = {
//    val factory = createConnFactory()
//    val conn = factory.createConnection(connParams.getUserName, connParams.getPassword)
//    conn.start()
//
//    conn
//  }
//
//  val conn: Connection = createConn
//
//  def close(): Unit = {
//    if (conn != null)
//      conn.close()
//  }
//
//}
//

trait MQProducer extends Closeable {

  protected def conn: Connection

  protected val session: Session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)

  protected def topicOrQueueName: String

  protected val isTopic: Boolean
  protected val dest: Destination =
    if (isTopic)
      session.createTopic(topicOrQueueName)
    else
      session.createQueue(topicOrQueueName)

  protected val producer: MessageProducer = session.createProducer(dest)

  val gson: Gson = MQ_JSON

  def sendText(text: String, typ: String = null): Unit = {
    val msg = session.createTextMessage(text)
    if (typ != null)
      msg.setStringProperty("typ", typ)
    producer.send(msg)
  }

  def send(msg: Object, typ: String = null): Unit = sendText(gson.toJson(msg), typ)

  override def close(): Unit = {
    if (producer != null)
      producer.close()
    if (session != null)
      session.close()
  }
}

case class DefaultTopicProducer(conn: Connection, topicOrQueueName: String) extends MQProducer {
  override protected val isTopic: Boolean = true
}

case class DefaultQueueProducer(conn: Connection, topicOrQueueName: String) extends MQProducer {
  override protected val isTopic: Boolean = false
}


trait DestinationDef {
  def isTopic: Boolean

  def name: String

  override def toString: String = {
    if (isTopic)
      s"Topic($name)"
    else
      s"Queue($name)"
  }
}

case class TopicDestination(name: String) extends DestinationDef {
  override def isTopic: Boolean = true
}

case class QueueDestination(name: String) extends DestinationDef {
  override def isTopic: Boolean = false
}

class MQSender[T](val connProvider: MQConnProvider, val destinationDef: DestinationDef) {

  import MQSender.logger

  val gson: Gson = MQ_JSON

  def typeOf(t: T): String = null

  def sendText(text: String, typ: String): Unit = {
    val conn = connProvider.getConn
    try {
      val session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)
      try {
        val dest =
          if (destinationDef.isTopic)
            session.createTopic(destinationDef.name)
          else
            session.createQueue(destinationDef.name)

        val producer = session.createProducer(dest)
        try {
          val msg = session.createTextMessage(text)
          if (typ != null)
            msg.setStringProperty("typ", typ)
          producer.send(msg)

          logger.whenDebugEnabled {
            if (destinationDef.isTopic)
              logger.debug(s"Send to topic `${destinationDef.name}`: $text.")
            else
              logger.debug(s"Send to queue `${destinationDef.name}`: $text.")
          }
        } finally {
          producer.close()
        }
      } finally {
        session.close()
      }
    } finally {
      conn.close()
    }
  }

  def send(msg: T): Unit = sendText(gson.toJson(msg), typeOf(msg))
}

object MQSender {
  private[mq] val logger = Logger(getClass.getName)

  def apply[T](connectionFactory: ConnectionFactory, destinationDef: DestinationDef): MQSender[T] =
    new MQSender[T](MQConnFactory(connectionFactory), destinationDef)
}

object JTMQDestinations {
  val GCmd = "g-cmd"
  val GCmdAck = "g-cmd-ack"
  //  val GTrack = "g-track"
  val GEvent = "g-event"
  //  val GPlatformAck = "g-platform-ack"
  val GGovSubmit = "g-gov-submit"
  val GDataChangeEvt = "g-dcn"
  val GStrmMedia = "g-strm-media"
  val GGovIssue = "g-gov-issue"
  val GGovIssueAck = "g-gov-issue-ack"

  val GGatewayReq = "g-gateway-req"
  val GGatewayResp = "g-gateway-resp"

  val GRtRgnChange = "g-rt-rgn-chg"

  val GStrmTokenChange = "g-strm-token-chg"

  val GTermAsync = "g-term-async"

  val G_CMD: TopicDestination = TopicDestination(GCmd)
  val G_CMD_ACK: TopicDestination = TopicDestination(GCmdAck)
  val G_EVENT: TopicDestination = TopicDestination(GEvent)
  val G_GOV_SUBMIT: TopicDestination = TopicDestination(GGovSubmit)
  val G_DATA_CHANGE_EVT: TopicDestination = TopicDestination(GDataChangeEvt)
  val G_STRM_MEDIA: TopicDestination = TopicDestination(GStrmMedia)
  val G_GOV_ISSUE: TopicDestination = TopicDestination(GGovIssue)
  val G_GOV_ISSUE_ACK: TopicDestination = TopicDestination(GGovIssueAck)

  val G_GATEWAY_REQ: TopicDestination = TopicDestination(GGatewayReq)
  val G_GATEWAY_RESP: TopicDestination = TopicDestination(GGatewayResp)

  val G_RT_RGN_CHANGE: TopicDestination = TopicDestination(GRtRgnChange)

  val G_STRM_TOKEN_CHANGE: TopicDestination = TopicDestination(GStrmTokenChange)

  val G_TERM_ASYNC: TopicDestination = TopicDestination(GTermAsync)
}

object JTMQClientSideDestinations {
  val ALM_NOTIFY = "/user/queue/alm"
  val STRM_NOTIFY = "/user/queue/strm"
  val CMD_ACK = "/user/queue/cmd_ack"
  val GOV_INSPECT = "/user/queue/gov_inspect"
  val ALM_SUPERVISE = "/user/queue/alm_supervise"
}

object JTKafkaMQTopics {

  /**
   * value format: info.gratour.adaptor.mq.dto.Event,
   *
   * event.msgId includes:
   * <ul>
   * <li>ONLINE</li>
   * <li>OFFLINE</li>
   * <li>0200</li>
   * </ul>
   */
  val TRK = "k-trk"
}


case class MQSender_GCmd(override val connProvider: MQConnProvider)
  extends MQSender[TermCmd](connProvider, JTMQDestinations.G_CMD)

object MQSender_GCmd {
  def apply(connectionFactory: ConnectionFactory): MQSender_GCmd =
    MQSender_GCmd(MQConnFactory(connectionFactory))
}

case class MQSender_GovSubmit(override val connProvider: MQConnProvider)
  extends MQSender[GovSubmitMsg](connProvider, JTMQDestinations.G_GOV_SUBMIT)

object MQSender_GovSubmit {
  def apply(connectionFactory: ConnectionFactory): MQSender_GovSubmit =
    MQSender_GovSubmit(MQConnFactory(connectionFactory))
}

case class MQSender_GDataChangeEvt(override val connProvider: MQConnProvider)
  extends MQSender[DataChangeEvent](connProvider, JTMQDestinations.G_DATA_CHANGE_EVT) {
  override def typeOf(t: DataChangeEvent): String = t.getTyp
}

object MQSender_GDataChangeEvt {
  def apply(connectionFactory: ConnectionFactory): MQSender_GDataChangeEvt =
    MQSender_GDataChangeEvt(MQConnFactory(connectionFactory))
}

case class MQSender_GStrmMedia(override val connProvider: MQConnProvider)
  extends MQSender[StrmMediaNotif](connProvider, JTMQDestinations.G_STRM_MEDIA)

object MQSender_GStrmMedia {
  def apply(connectionFactory: ConnectionFactory): MQSender_GStrmMedia =
    MQSender_GStrmMedia(MQConnFactory(connectionFactory))
}

case class MQSender_GovIssue(override val connProvider: MQConnProvider)
  extends MQSender[GovIssueMsg](connProvider, JTMQDestinations.G_GOV_ISSUE)

object MQSender_GovIssue {
  def apply(connectionFactory: ConnectionFactory): MQSender_GovIssue =
    MQSender_GovIssue(MQConnFactory(connectionFactory))
}

case class MQSender_GovIssueAck(override val connProvider: MQConnProvider)
  extends MQSender[GovIssueAckMsg](connProvider, JTMQDestinations.G_GOV_ISSUE_ACK)

object MQSender_GovIssueAck {
  def apply(connectionFactory: ConnectionFactory): MQSender_GovIssueAck =
    MQSender_GovIssueAck(MQConnFactory(connectionFactory))
}

case class MQSender_GatewayReq(override val connProvider: MQConnProvider)
  extends MQSender[GatewayReq](connProvider, JTMQDestinations.G_GATEWAY_REQ)

object MQSender_GatewayReq {
  def apply(connectionFactory: ConnectionFactory): MQSender_GatewayReq =
    MQSender_GatewayReq(MQConnFactory(connectionFactory))
}

case class MQSender_GatewayResp(override val connProvider: MQConnProvider)
  extends MQSender[GatewayResp](connProvider, JTMQDestinations.G_GATEWAY_RESP)

object MQSender_GatewayResp {
  def apply(connectionFactory: ConnectionFactory): MQSender_GatewayResp =
    MQSender_GatewayResp(MQConnFactory(connectionFactory))
}

case class MQSender_RtRgnChange(override val connProvider: MQConnProvider)
  extends MQSender[RtRgnChange](connProvider, JTMQDestinations.G_RT_RGN_CHANGE)

object MQSender_RtRgnChange {
  def apply(connectionFactory: ConnectionFactory): MQSender_RtRgnChange =
    MQSender_RtRgnChange(MQConnFactory(connectionFactory))
}

case class MQSender_StrmTokenChange(override val connProvider: MQConnProvider)
  extends MQSender[StrmMediaApi.UpdateTimedTokenReq](connProvider, JTMQDestinations.G_STRM_TOKEN_CHANGE)

object MQSender_StrmTokenChange {
  def apply(connectionFactory: ConnectionFactory): MQSender_StrmTokenChange =
    MQSender_StrmTokenChange(MQConnFactory(connectionFactory))
}

trait MQConsumer extends Closeable {
  protected def conn: Connection

  protected val session: Session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)

  protected def destinationDef: DestinationDef

  protected val dest: Destination =
    if (destinationDef.isTopic)
      session.createTopic(destinationDef.name)
    else
      session.createQueue(destinationDef.name)

  protected def messageSelector: String = null

  val gson: Gson = MQ_JSON

  protected val consumer: MessageConsumer = session.createConsumer(dest, messageSelector)
  consumer.setMessageListener {
    case text: TextMessage =>
      onMsg(text.getText)
    case _ =>
  }

  protected def onMsg(message: String): Unit

  override def close(): Unit = {
    if (consumer != null)
      consumer.close()
    if (session != null)
      session.close()
  }
}
