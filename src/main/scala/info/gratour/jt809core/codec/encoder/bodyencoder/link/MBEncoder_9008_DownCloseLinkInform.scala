package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.MsgBodyEncoder
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9008_DownCloseLinkInform
import io.netty.buffer.ByteBuf

object MBEncoder_9008_DownCloseLinkInform extends MsgBodyEncoder{
  override def msgId: Int = JT809Msg_9008_DownCloseLinkInform.MSG_ID

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    out.writeByte(m.asInstanceOf[JT809Msg_9008_DownCloseLinkInform].getReasonCode)
  }
}
