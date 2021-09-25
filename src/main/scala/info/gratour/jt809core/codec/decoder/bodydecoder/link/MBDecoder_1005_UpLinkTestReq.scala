package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1005_UpLinkTestReq
import io.netty.buffer.ByteBuf

object MBDecoder_1005_UpLinkTestReq extends SimpleJT809MsgBodyDecoder[JT809Msg_1005_UpLinkTestReq]{
  override def msgClass: Class[JT809Msg_1005_UpLinkTestReq] = classOf[JT809Msg_1005_UpLinkTestReq]

  override def decodeBody(msg: JT809Msg_1005_UpLinkTestReq, buf: ByteBuf): Unit = {
    // nop
  }
}
