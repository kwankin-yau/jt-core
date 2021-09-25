package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1007_UpDisconnectInform
import io.netty.buffer.ByteBuf

object MBDecoder_1007_UpDisconnectInform extends SimpleJT809MsgBodyDecoder[JT809Msg_1007_UpDisconnectInform]{
  override def msgClass: Class[JT809Msg_1007_UpDisconnectInform] = classOf[JT809Msg_1007_UpDisconnectInform]

  override def decodeBody(msg: JT809Msg_1007_UpDisconnectInform, buf: ByteBuf): Unit = {
    msg.setErrorCode(buf.readByte())
  }
}
