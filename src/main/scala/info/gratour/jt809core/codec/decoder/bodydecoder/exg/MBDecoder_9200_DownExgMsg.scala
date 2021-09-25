package info.gratour.jt809core.codec.decoder.bodydecoder.exg

import java.util

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.exg.{JT809DownExgMsg, JT809Msg_9202_DownExgMsgCarLocation, JT809Msg_9203_DownExgMsgHistoryAcrossArea, JT809Msg_9204_DownExgMsgCarInfo, JT809Msg_9205_DownExgMsgReturnStartup, JT809Msg_9206_DownExgMsgReturnEnd, JT809Msg_9207_DownExgMsgApplyForMonitorStartupAck, JT809Msg_9208_DownExgMsgApplyForMonitorEndAck, JT809Msg_9209_DownExgMsgApplyHisGnssDataAck, JT809Msg_920A_DownExgMsgReportDriverInfo, JT809Msg_920B_DownExgMsgTakeEWayBillReq}
import info.gratour.jt809core.protocol.msg.types.JT809GnssData
import io.netty.buffer.ByteBuf

object MBDecoder_9200_DownExgMsg extends VehRelatedMsgBodyDecoder {
  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9202_DownExgMsgCarLocation =>
        m.setGnssData(decodeGnssData(buf))

      case m: JT809Msg_9203_DownExgMsgHistoryAcrossArea =>
        val count = buf.readUnsignedByte()
        val list = new util.ArrayList[JT809GnssData]()
        for (i <- 0 until(count)) {
          list.add(decodeGnssData(buf))
        }
        m.setGnssDataList(list)

      case m: JT809Msg_9204_DownExgMsgCarInfo =>
        m.setCarInfo(buf.readRemainingAsStr())

      case m: JT809Msg_9205_DownExgMsgReturnStartup =>
        m.setReasonCode(buf.readByte())

      case m: JT809Msg_9206_DownExgMsgReturnEnd =>
        m.setReasonCode(buf.readByte())

      case m: JT809Msg_9207_DownExgMsgApplyForMonitorStartupAck =>
        m.setResult(buf.readByte())

      case m: JT809Msg_9208_DownExgMsgApplyForMonitorEndAck =>
        m.setResult(buf.readByte())

      case m: JT809Msg_9209_DownExgMsgApplyHisGnssDataAck =>
        m.setResult(buf.readByte())

      case _: JT809Msg_920A_DownExgMsgReportDriverInfo =>
        // do nothing

      case _: JT809Msg_920B_DownExgMsgTakeEWayBillReq =>
        // do nothing
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_9202_DownExgMsgCarLocation],
    classOf[JT809Msg_9203_DownExgMsgHistoryAcrossArea],
    classOf[JT809Msg_9204_DownExgMsgCarInfo],
    classOf[JT809Msg_9205_DownExgMsgReturnStartup],
    classOf[JT809Msg_9206_DownExgMsgReturnEnd],
    classOf[JT809Msg_9207_DownExgMsgApplyForMonitorStartupAck],
    classOf[JT809Msg_9208_DownExgMsgApplyForMonitorEndAck],
    classOf[JT809Msg_9209_DownExgMsgApplyHisGnssDataAck],
    classOf[JT809Msg_920A_DownExgMsgReportDriverInfo],
    classOf[JT809Msg_920B_DownExgMsgTakeEWayBillReq]
  )

  override def msgId: Int = JT809DownExgMsg.MSG_ID
}
