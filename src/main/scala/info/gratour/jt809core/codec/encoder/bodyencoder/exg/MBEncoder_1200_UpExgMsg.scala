package info.gratour.jt809core.codec.encoder.bodyencoder.exg

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.exg._
import io.netty.buffer.ByteBuf
import org.apache.commons.lang3.StringUtils

object MBEncoder_1200_UpExgMsg extends VehRelatedMsgBodyEncoder {

  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1201_UpExgMsgRegister =>
        out.writeFixedLenStr(m.getPlatformId, 11)
        out.writeFixedLenStr(m.getProducerId, 11)
        out.writeFixedLenStr(m.getTerminalModelType, 8)
        out.writeFixedLenStr(m.getTerminalId, 7)
        var simCode = m.getTerminalSimCode
        if (simCode.length > 12)
          simCode.substring(0, 12)
        else if (simCode.length < 12)
          simCode = StringUtils.leftPad(simCode, 12, '0')
        out.writeStr(simCode)


      case m: JT809Msg_1202_UpExgMsgRealLocation =>
        out.writeGnssData(m.getGnssData)

      case m: JT809Msg_1203_UpExgMsgHistoryLocation =>
        out.writeByte(m.getGnssDataList.size())
        m.getGnssDataList.forEach(out.writeGnssData(_))

      case _: JT809Msg_1205_UpExgMsgReturnStartupAck =>
        // nop

      case _: JT809Msg_1206_UpExgMsgReturnEndAck =>
        // nop

      case m: JT809Msg_1207_UpExgMsgApplyForMonitorStartup =>
        out.writeLong(m.getStartTime)
        out.writeLong(m.getEndTime)

      case _: JT809Msg_1208_UpExgMsgApplyForMonitorEnd =>
        // nop

      case m: JT809Msg_1209_UpExgMsgApplyHisGnssDataReq =>
        out.writeLong(m.getStartTime)
        out.writeLong(m.getEndTime)

      case m: JT809Msg_120A_UpExgMsgReportDriverInfoAck =>
        out.writeFixedLenStr(m.getDriverName, 16)
        out.writeFixedLenStr(m.getDriverId, 20)
        out.writeFixedLenStr(m.getLicence, 40)
        out.writeFixedLenStr(m.getOrgName, 200)

      case m: JT809Msg_120B_UpExgMsgTakeEWayBillAck =>
        out.writeIntLenPrefixedStr(m.getEWayBillInfo)
    }
  }

  override def msgId: Int = JT809UpExgMsg.MSG_ID
}
