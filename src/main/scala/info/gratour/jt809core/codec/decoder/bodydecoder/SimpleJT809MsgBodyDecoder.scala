package info.gratour.jt809core.codec.decoder.bodydecoder

import info.gratour.jt809core.protocol.{JT809FrameHeader, JT809Msg}
import io.netty.buffer.ByteBuf

trait SimpleJT809MsgBodyDecoder[M <: JT809Msg] extends JT809MsgBodyDecoder {

  def msgClass: Class[M]

  def decodeBody(msg: M, buf: ByteBuf): Unit

  override def msgId: Int = msgClass.getField("MSG_ID").getInt(null)

  override def decode(header: JT809FrameHeader, body: ByteBuf): JT809Msg = {
    val instance = msgClass.newInstance()
    instance.setHeader(header)
    decodeBody(instance, body)
    instance
  }
}
