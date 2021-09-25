package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9008_DownCloseLinkInform
import io.netty.buffer.ByteBuf

object MBDecoder_9008_DownCloseLinkInform extends SimpleJT809MsgBodyDecoder[JT809Msg_9008_DownCloseLinkInform]{
  override def msgClass: Class[JT809Msg_9008_DownCloseLinkInform] = classOf[JT809Msg_9008_DownCloseLinkInform]

  override def decodeBody(msg: JT809Msg_9008_DownCloseLinkInform, buf: ByteBuf): Unit = {
    msg.setReasonCode(buf.readByte())
  }
}
