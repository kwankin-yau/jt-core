package info.gratour.jt809core.codec.decoder.bodydecoder.link

import info.gratour.jt809core.codec.decoder.bodydecoder.SimpleJT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1001_UpConnectReq
import io.netty.buffer.ByteBuf

object MBDecoder_1001_UpConnectReq extends SimpleJT809MsgBodyDecoder[JT809Msg_1001_UpConnectReq] {


  override def decodeBody(msg: JT809Msg_1001_UpConnectReq, buf: ByteBuf): Unit = {
    msg.setUserId(buf.readInt())
    msg.setPassword(buf.readStrMaxLen(8))
    msg.setDownLinkIp(buf.readStrMaxLen(32))
    msg.setDownLinkPort(buf.readUnsignedShort())
  }

  override def msgClass: Class[JT809Msg_1001_UpConnectReq] = classOf[JT809Msg_1001_UpConnectReq]
}

