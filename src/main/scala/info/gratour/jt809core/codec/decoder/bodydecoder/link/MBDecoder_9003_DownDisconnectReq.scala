package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9003_DownDisconnectReq
import io.netty.buffer.ByteBuf

object MBDecoder_9003_DownDisconnectReq extends SimpleJT809MsgBodyDecoder[JT809Msg_9003_DownDisconnectReq]{
  override def msgClass: Class[JT809Msg_9003_DownDisconnectReq] = classOf[JT809Msg_9003_DownDisconnectReq]

  override def decodeBody(msg: JT809Msg_9003_DownDisconnectReq, buf: ByteBuf): Unit = {
    msg.setVerifyCode(buf.readInt())
  }
}
