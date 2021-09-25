package info.gratour.jt809core.codec.encoder.bodyencoder.platform

import info.gratour.common.error.ErrorWithCode
import info.gratour.jt809core.protocol.msg.platform.{JT809Msg_1301_UpPlatformMsgPostQueryAck, JT809Msg_1302_UpPlatformMsgInfoAck, JT809PlatformMsg, JT809UpPlatformMsg}
import io.netty.buffer.ByteBuf


object MBEncoder_1300_UpPlatformMsg extends PlatformMsgEncoder {
  override def msgId: Int = JT809UpPlatformMsg.MSG_ID

  override def encodeSubBody(m: JT809PlatformMsg, out: ByteBuf): Unit = {
    m match {
      case m: JT809Msg_1301_UpPlatformMsgPostQueryAck =>
        out.writeByte(m.getObjectType)
        out.writeFixedLenStr(m.getObjectId, 20)
        out.writeInt(m.getInfoId)
        out.writeIntLenPrefixedStr(m.getInfoContent)

      case m: JT809Msg_1302_UpPlatformMsgInfoAck =>
        out.writeInt(m.getInfoId)

      case _ =>
        throw ErrorWithCode.internalError("Not implemented.")
    }

  }
}
