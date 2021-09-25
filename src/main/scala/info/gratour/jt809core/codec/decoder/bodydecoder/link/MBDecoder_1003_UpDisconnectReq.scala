package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1003_UpDisconnectReq
import io.netty.buffer.ByteBuf

object MBDecoder_1003_UpDisconnectReq extends SimpleJT809MsgBodyDecoder[JT809Msg_1003_UpDisconnectReq] {
  override def msgClass: Class[JT809Msg_1003_UpDisconnectReq] = classOf[JT809Msg_1003_UpDisconnectReq]

  override def decodeBody(msg: JT809Msg_1003_UpDisconnectReq, buf: ByteBuf): Unit = {
    msg.setUserId(buf.readInt())
    msg.setPassword(buf.readStrMaxLen(8))
  }
}
