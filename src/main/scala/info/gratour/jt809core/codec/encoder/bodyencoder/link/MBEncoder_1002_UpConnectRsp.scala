package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.MsgBodyEncoder
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1002_UpConnectRsp
import io.netty.buffer.ByteBuf

object MBEncoder_1002_UpConnectRsp extends MsgBodyEncoder{
  override def msgId: Int = JT809Msg_1002_UpConnectRsp.MSG_ID

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    val msg = m.asInstanceOf[JT809Msg_1002_UpConnectRsp]
    out.writeByte(msg.getResult)
    out.writeInt(msg.getVerifyCode)
  }
}
