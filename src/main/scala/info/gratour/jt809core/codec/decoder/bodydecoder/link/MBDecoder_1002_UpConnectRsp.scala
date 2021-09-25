package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1002_UpConnectRsp
import io.netty.buffer.ByteBuf

object MBDecoder_1002_UpConnectRsp extends SimpleJT809MsgBodyDecoder[JT809Msg_1002_UpConnectRsp] {
  override def msgClass: Class[JT809Msg_1002_UpConnectRsp] = classOf[JT809Msg_1002_UpConnectRsp]

  override def decodeBody(msg: JT809Msg_1002_UpConnectRsp, buf: ByteBuf): Unit = {
    msg.setResult(buf.readByte())
    msg.setVerifyCode(buf.readInt())
  }
}
