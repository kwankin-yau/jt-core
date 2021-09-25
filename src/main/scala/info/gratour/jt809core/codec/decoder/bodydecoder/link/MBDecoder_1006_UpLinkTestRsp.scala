package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1006_UpLinkTestRsp
import io.netty.buffer.ByteBuf

object MBDecoder_1006_UpLinkTestRsp extends SimpleJT809MsgBodyDecoder[JT809Msg_1006_UpLinkTestRsp]{
  override def msgClass: Class[JT809Msg_1006_UpLinkTestRsp] = classOf[JT809Msg_1006_UpLinkTestRsp]

  override def decodeBody(msg: JT809Msg_1006_UpLinkTestRsp, buf: ByteBuf): Unit = {
    // nop
  }
}
