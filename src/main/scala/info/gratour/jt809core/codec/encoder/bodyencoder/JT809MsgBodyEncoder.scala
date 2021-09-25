package info.gratour.jt809core.codec.encoder.bodyencoder

import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jtcommon.JTCodecHelper
import io.netty.buffer.ByteBuf

trait MsgBodyEncoder extends JTCodecHelper {

  def msgId: Int
  def encodeBody(m: JT809Msg, out: ByteBuf): Unit

}

trait EmptyMsgBodyEncoder extends MsgBodyEncoder {

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    // nop
  }
}
