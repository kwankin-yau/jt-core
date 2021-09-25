package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1008_UpCloseLinkInform
import io.netty.buffer.ByteBuf

object MBDecoder_1008_UpCloseLinkInform extends SimpleJT809MsgBodyDecoder[JT809Msg_1008_UpCloseLinkInform]{
  override def msgClass: Class[JT809Msg_1008_UpCloseLinkInform] = classOf[JT809Msg_1008_UpCloseLinkInform]

  override def decodeBody(msg: JT809Msg_1008_UpCloseLinkInform, buf: ByteBuf): Unit = {
    msg.setReasonCode(buf.readByte())
  }
}
