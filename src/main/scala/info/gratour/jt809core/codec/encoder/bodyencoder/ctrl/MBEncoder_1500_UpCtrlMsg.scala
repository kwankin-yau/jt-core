package info.gratour.jt809core.codec.encoder.bodyencoder.ctrl

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.ctrl._
import io.netty.buffer.ByteBuf

object MBEncoder_1500_UpCtrlMsg extends VehRelatedMsgBodyEncoder {

  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1501_UpCtrlMsgMonitorVehicleAck =>
        out.writeByte(m.getResult)

      case m: JT809Msg_1502_UpCtrlMsgTakePhotoAck =>
        out.writeByte(m.getPhotoRspFlag)
        if (m.getGnssData != null)
          out.writeGnssData(m.getGnssData)
        else
          out.writeZero(36)
        out.writeByte(m.getLensId)
        val binary = m.getPhotoBinary
        if (binary != null)
          out.writeInt(binary.length)
        else
          out.writeInt(0)
        out.writeByte(m.getSizeType)
        out.writeByte(m.getFormat)
        if (binary != null)
          out.writeBytes(binary)

      case m: JT809Msg_1503_UpCtrlMsgTextInfoAck =>
        out.writeInt(m.getReqMsgId)
        out.writeByte(m.getResult)

      case m: JT809Msg_1504_UpCtrlMsgTakeTravelAck =>
        out.writeByte(m.getCommandType)
        out.writeIntLenPrefixedStr(m.getTravelDataInfo)

      case m: JT809Msg_1505_UpCtrlMsgEmergencyMonitoringAck =>
        out.writeByte(m.getResult)
    }
  }

  override def msgId: Int = JT809UpCtrlMsg.MSG_ID
}
