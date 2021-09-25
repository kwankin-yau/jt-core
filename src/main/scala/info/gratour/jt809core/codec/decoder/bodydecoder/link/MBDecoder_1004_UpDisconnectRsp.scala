package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1004_UpDisconnectRsp
import io.netty.buffer.ByteBuf

object MBDecoder_1004_UpDisconnectRsp extends SimpleJT809MsgBodyDecoder[JT809Msg_1004_UpDisconnectRsp] {
  override def msgClass: Class[JT809Msg_1004_UpDisconnectRsp] = classOf[JT809Msg_1004_UpDisconnectRsp]

  override def decodeBody(msg: JT809Msg_1004_UpDisconnectRsp, buf: ByteBuf): Unit = {
    // nop
  }
}
