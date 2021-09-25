package info.gratour.jt809core.codec.encoder.bodyencoder.exg

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.exg._
import io.netty.buffer.ByteBuf

object MBEncoder_9200_DownExgMsg extends VehRelatedMsgBodyEncoder {
  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9202_DownExgMsgCarLocation =>
        out.writeGnssData(m.getGnssData)

      case m: JT809Msg_9203_DownExgMsgHistoryAcrossArea =>
        out.writeByte(m.getGnssDataList.size())
        m.getGnssDataList.forEach(out.writeGnssData(_))

      case m: JT809Msg_9204_DownExgMsgCarInfo =>
        out.writeStr(m.getCarInfo)

      case m: JT809Msg_9205_DownExgMsgReturnStartup =>
        out.writeByte(m.getReasonCode)

      case m: JT809Msg_9206_DownExgMsgReturnEnd =>
        out.writeByte(m.getReasonCode)

      case m: JT809Msg_9207_DownExgMsgApplyForMonitorStartupAck =>
        out.writeByte(m.getResult)

      case m: JT809Msg_9208_DownExgMsgApplyForMonitorEndAck =>
        out.writeByte(m.getResult)

      case m: JT809Msg_9209_DownExgMsgApplyHisGnssDataAck =>
        out.writeByte(m.getResult)

      case _: JT809Msg_920A_DownExgMsgReportDriverInfo =>
        // nop

      case _: JT809Msg_920B_DownExgMsgTakeEWayBillReq =>
        // nop
    }
  }

  override def msgId: Int = JT809DownExgMsg.MSG_ID
}
