package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.MsgBodyEncoder
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1003_UpDisconnectReq
import io.netty.buffer.ByteBuf

object MBEncoder_1003_UpDisconnectReq extends MsgBodyEncoder{
  override def msgId: Int = JT809Msg_1003_UpDisconnectReq.MSG_ID

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    val msg = m.asInstanceOf[JT809Msg_1003_UpDisconnectReq]
    out.writeInt(msg.getUserId)
    out.writeFixedLenStr(msg.getPassword, 8)
  }
}
