package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9002_DownConnectRsp
import io.netty.buffer.ByteBuf

object MBDecoder_9002_DownConnectRsp extends SimpleJT809MsgBodyDecoder[JT809Msg_9002_DownConnectRsp]{
  override def msgClass: Class[JT809Msg_9002_DownConnectRsp] = classOf[JT809Msg_9002_DownConnectRsp]

  override def decodeBody(msg: JT809Msg_9002_DownConnectRsp, buf: ByteBuf): Unit = {
    msg.setResult(buf.readByte())
  }
}
