package info.gratour.jt809core.codec.decoder.bodydecoder.ctrl

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.ctrl._
import io.netty.buffer.ByteBuf

object MBDecoder_9500_DownCtrlMsg extends VehRelatedMsgBodyDecoder {

  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9501_DownCtrlMsgMonitorVehicleReq =>
        m.setMonitorTel(buf.readRemainingAsStr())

      case m: JT809Msg_9502_DownCtrlMsgTakePhotoReq =>
        m.setLensId(buf.readByte())
        m.setSizeType(buf.readByte())

      case m: JT809Msg_9503_DownCtrlMsgTextInfoReq =>
        m.setMsgSeqNo(buf.readInt())
        m.setMsgPriority(buf.readByte())
        m.setMsgContent(buf.readIntLenPrefixedStr())

      case m: JT809Msg_9504_DownCtrlMsgTakeTravelReq =>
        m.setCommandType(buf.readByte())

      case m: JT809Msg_9505_DownCtrlMsgEmergencyMonitoringReq =>
        m.setAuthenticationCode(buf.readStrMaxLen(10))
        m.setAccessPointName(buf.readStrMaxLen(20))
        m.setUserName(buf.readStrMaxLen(49))
        m.setPassword(buf.readStrMaxLen(22))
        m.setServerIp(buf.readStrMaxLen(32))
        m.setTcpPort(buf.readUnsignedShort())
        m.setUdpPort(buf.readUnsignedShort())
        m.setEndTime(buf.readLong())
    }
  }

  override def msgId: Int = JT809DownCtrlMsg.MSG_ID

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_9501_DownCtrlMsgMonitorVehicleReq],
    classOf[JT809Msg_9502_DownCtrlMsgTakePhotoReq],
    classOf[JT809Msg_9503_DownCtrlMsgTextInfoReq],
    classOf[JT809Msg_9504_DownCtrlMsgTakeTravelReq],
    classOf[JT809Msg_9505_DownCtrlMsgEmergencyMonitoringReq]
  )

}
