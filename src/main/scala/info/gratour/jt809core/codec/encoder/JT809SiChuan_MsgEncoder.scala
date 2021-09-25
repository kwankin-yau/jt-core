package info.gratour.jt809core.codec.encoder

import info.gratour.jt809core.codec.encoder.bodyencoder.{JT809MsgBodyEncoderRegistry, JT809SiChuan_MsgBodyEncoderRegistry}
import io.netty.buffer.ByteBufAllocator

class JT809SiChuan_MsgEncoder(override val byteBufAllocator: ByteBufAllocator) extends JT809R2011_MsgEncoder(byteBufAllocator) {

  override protected def getMsgBodyEncoderRegistry: JT809MsgBodyEncoderRegistry = JT809SiChuan_MsgBodyEncoderRegistry
}
