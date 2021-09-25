package info.gratour.jt809core.codec.encoder.bodyencoder.platform
import info.gratour.jt809core.protocol.msg.platform.{JT809DownPlatformMsg, JT809Msg_9301_DownPlatformMsgPostQueryReq, JT809Msg_9302_DownPlatformMsgInfoReq, JT809PlatformMsg, JT809UpPlatformMsg}
import io.netty.buffer.ByteBuf

object MBEncoder_9300_DownPlatformMsg extends PlatformMsgEncoder {
  override def encodeSubBody(m: JT809PlatformMsg, out: ByteBuf): Unit = {
    m match {
      case msg: JT809Msg_9301_DownPlatformMsgPostQueryReq =>
        out.writeByte(msg.getObjectType)
        out.writeFixedLenStr(msg.getObjectId, 20)
        out.writeInt(msg.getInfoId)
        out.writeIntLenPrefixedStr(msg.getInfoContent)

      case msg: JT809Msg_9302_DownPlatformMsgInfoReq =>
        out.writeByte(msg.getObjectType)
        out.writeFixedLenStr(msg.getObjectId, 20)
        out.writeInt(msg.getInfoId)
        out.writeIntLenPrefixedStr(msg.getInfoContent)
    }
  }

  override def msgId: Int = JT809DownPlatformMsg.MSG_ID
}
