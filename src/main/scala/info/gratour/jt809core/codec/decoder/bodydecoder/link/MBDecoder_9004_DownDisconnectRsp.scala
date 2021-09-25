package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9004_DownDisconnectRsp
import io.netty.buffer.ByteBuf

object MBDecoder_9004_DownDisconnectRsp extends SimpleJT809MsgBodyDecoder[JT809Msg_9004_DownDisconnectRsp]{
  override def msgClass: Class[JT809Msg_9004_DownDisconnectRsp] = classOf[JT809Msg_9004_DownDisconnectRsp]

  override def decodeBody(msg: JT809Msg_9004_DownDisconnectRsp, buf: ByteBuf): Unit = {
    // nop
  }
}
