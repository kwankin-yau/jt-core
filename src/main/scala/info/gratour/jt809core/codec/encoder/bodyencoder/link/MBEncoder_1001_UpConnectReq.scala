package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.MsgBodyEncoder
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1001_UpConnectReq
import io.netty.buffer.ByteBuf

object MBEncoder_1001_UpConnectReq extends MsgBodyEncoder {
  override def msgId: Int = JT809Msg_1001_UpConnectReq.MSG_ID

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    val msg = m.asInstanceOf[JT809Msg_1001_UpConnectReq]
    out.writeInt(msg.getUserId)
    out.writeFixedLenStr(msg.getPassword, 8)
    out.writeFixedLenStr(msg.getDownLinkIp, 32)
    out.writeShort(msg.getDownLinkPort)
  }
}
