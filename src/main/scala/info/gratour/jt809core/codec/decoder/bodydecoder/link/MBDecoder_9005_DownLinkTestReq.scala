package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9005_DownLinkTestReq
import io.netty.buffer.ByteBuf

object MBDecoder_9005_DownLinkTestReq extends SimpleJT809MsgBodyDecoder[JT809Msg_9005_DownLinkTestReq]{
  override def msgClass: Class[JT809Msg_9005_DownLinkTestReq] = classOf[JT809Msg_9005_DownLinkTestReq]

  override def decodeBody(msg: JT809Msg_9005_DownLinkTestReq, buf: ByteBuf): Unit = {
    // nop
  }
}
