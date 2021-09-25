package info.gratour.jt809core.codec.encoder.bodyencoder.platform

import info.gratour.jt809core.codec.encoder.bodyencoder.MsgBodyEncoder
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.protocol.msg.platform.JT809PlatformMsg
import io.netty.buffer.ByteBuf

trait PlatformMsgEncoder extends MsgBodyEncoder {

  def encodeSubBody(m: JT809PlatformMsg, out: ByteBuf): Unit

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    val msg = m.asInstanceOf[JT809PlatformMsg]
    out.writeShort(msg.getDataType)
    val dataSizeOffset = out.writerIndex()
    out.writeInt(0) // size stub
    encodeSubBody(msg, out)
    val size = out.writerIndex() - dataSizeOffset
    out.setInt(dataSizeOffset, size)
  }
}
