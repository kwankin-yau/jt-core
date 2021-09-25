package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9001_DownConnectReq
import io.netty.buffer.ByteBuf

object MBDecoder_9001_DownConnectReq extends SimpleJT809MsgBodyDecoder[JT809Msg_9001_DownConnectReq]{
  override def msgClass: Class[JT809Msg_9001_DownConnectReq] = classOf[JT809Msg_9001_DownConnectReq]

  override def decodeBody(msg: JT809Msg_9001_DownConnectReq, buf: ByteBuf): Unit = {
    msg.setVerifyCode(buf.readInt())
  }
}
