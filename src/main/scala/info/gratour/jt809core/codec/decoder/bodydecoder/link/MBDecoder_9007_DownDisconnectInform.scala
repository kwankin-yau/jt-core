package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9007_DownDisconnectInform
import io.netty.buffer.ByteBuf

object MBDecoder_9007_DownDisconnectInform extends SimpleJT809MsgBodyDecoder[JT809Msg_9007_DownDisconnectInform]{
  override def msgClass: Class[JT809Msg_9007_DownDisconnectInform] = classOf[JT809Msg_9007_DownDisconnectInform]

  override def decodeBody(msg: JT809Msg_9007_DownDisconnectInform, buf: ByteBuf): Unit = {
    msg.setErrorCode(buf.readByte())
  }
}
