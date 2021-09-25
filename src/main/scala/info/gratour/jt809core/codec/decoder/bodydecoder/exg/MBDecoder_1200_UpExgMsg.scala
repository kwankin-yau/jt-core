package info.gratour.jt809core.codec.decoder.bodydecoder.exg

import java.util

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.exg._
import info.gratour.jt809core.protocol.msg.types.JT809GnssData
import io.netty.buffer.ByteBuf

object MBDecoder_1200_UpExgMsg extends VehRelatedMsgBodyDecoder {
  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1201_UpExgMsgRegister =>
        m.setPlatformId(buf.readStrMaxLen(11))
        m.setProducerId(buf.readStrMaxLen(11))
        m.setTerminalModelType(buf.readStrMaxLen(8))
        m.setTerminalId(buf.readStrMaxLen(7))
        m.setTerminalSimCode(buf.readStrMaxLen(12))

      case m: JT809Msg_1202_UpExgMsgRealLocation =>
        m.setGnssData(decodeGnssData(buf))

      case m: JT809Msg_1203_UpExgMsgHistoryLocation =>
        val count = buf.readUnsignedByte()
        val list = new util.ArrayList[JT809GnssData]()
        for (i <- 0 until count) {
          list.add(decodeGnssData(buf))
        }
        m.setGnssDataList(list)

      case _: JT809Msg_1205_UpExgMsgReturnStartupAck =>
      // do nothing

      case _: JT809Msg_1206_UpExgMsgReturnEndAck =>
      // do nothing

      case m: JT809Msg_1207_UpExgMsgApplyForMonitorStartup =>
        m.setStartTime(buf.readLong())
        m.setEndTime(buf.readLong())

      case _: JT809Msg_1208_UpExgMsgApplyForMonitorEnd =>
      // do nothing

      case m: JT809Msg_1209_UpExgMsgApplyHisGnssDataReq =>
        m.setStartTime(buf.readLong())
        m.setEndTime(buf.readLong())

      case m: JT809Msg_120A_UpExgMsgReportDriverInfoAck =>
        m.setDriverName(buf.readStrMaxLen(16))
        m.setDriverId(buf.readStrMaxLen(20))
        m.setLicence(buf.readStrMaxLen(40))
        m.setOrgName(buf.readStrMaxLen(200))

      case m: JT809Msg_120B_UpExgMsgTakeEWayBillAck =>
        m.setEWayBillInfo(buf.readIntLenPrefixedStr())
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_1201_UpExgMsgRegister],
    classOf[JT809Msg_1202_UpExgMsgRealLocation],
    classOf[JT809Msg_1203_UpExgMsgHistoryLocation],
    classOf[JT809Msg_1205_UpExgMsgReturnStartupAck],
    classOf[JT809Msg_1206_UpExgMsgReturnEndAck],
    classOf[JT809Msg_1207_UpExgMsgApplyForMonitorStartup],
    classOf[JT809Msg_1208_UpExgMsgApplyForMonitorEnd],
    classOf[JT809Msg_1209_UpExgMsgApplyHisGnssDataReq],
    classOf[JT809Msg_120A_UpExgMsgReportDriverInfoAck],
    classOf[JT809Msg_120B_UpExgMsgTakeEWayBillAck]
  )

  override def msgId: Int = JT809UpExgMsg.MSG_ID
}
