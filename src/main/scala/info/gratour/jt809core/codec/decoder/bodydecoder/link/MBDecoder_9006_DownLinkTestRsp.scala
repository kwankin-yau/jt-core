package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9006_DownLinkTestRsp
import io.netty.buffer.ByteBuf

object MBDecoder_9006_DownLinkTestRsp extends SimpleJT809MsgBodyDecoder[JT809Msg_9006_DownLinkTestRsp]{
  override def msgClass: Class[JT809Msg_9006_DownLinkTestRsp] = classOf[JT809Msg_9006_DownLinkTestRsp]

  override def decodeBody(msg: JT809Msg_9006_DownLinkTestRsp, buf: ByteBuf): Unit = {
    // nop
  }
}
