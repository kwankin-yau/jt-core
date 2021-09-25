package info.gratour.jt809core.codec.encoder.bodyencoder.ctrl

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.ctrl._
import io.netty.buffer.ByteBuf

object MBEncoder_9500_DownCtrlMsg extends VehRelatedMsgBodyEncoder {

  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9501_DownCtrlMsgMonitorVehicleReq =>
        out.writeStr(m.getMonitorTel)


      case m: JT809Msg_9502_DownCtrlMsgTakePhotoReq =>
        out.writeByte(m.getLensId)
        out.writeByte(m.getSizeType)

      case m: JT809Msg_9503_DownCtrlMsgTextInfoReq =>
        out.writeInt(m.getMsgSeqNo)
        out.writeByte(m.getMsgPriority)
        out.writeIntLenPrefixedStr(m.getMsgContent)

      case m: JT809Msg_9504_DownCtrlMsgTakeTravelReq =>
        out.writeByte(m.getCommandType)

      case m: JT809Msg_9505_DownCtrlMsgEmergencyMonitoringReq =>
        out.writeFixedLenStr(m.getAuthenticationCode, 10)
        out.writeFixedLenStr(m.getAccessPointName, 20)
        out.writeFixedLenStr(m.getUserName, 49)
        out.writeFixedLenStr(m.getPassword, 22)
        out.writeFixedLenStr(m.getServerIp, 32)
        out.writeShort(m.getTcpPort)
        out.writeShort(m.getUdpPort)
        out.writeLong(m.getEndTime)
    }
  }

  override def msgId: Int = JT809DownCtrlMsg.MSG_ID
}
