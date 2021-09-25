package info.gratour.jt809core.codec.decoder

import info.gratour.jt809core.codec.decoder.bodydecoder.{JT809MsgBodyDecoderRegistry, JT809SiChuan_MsgBodyDecoderRegistry}
import info.gratour.jt809core.types.GnssCenterRegistry
import io.netty.buffer.ByteBufAllocator

class JT809SiChuan_MsgDecoder(override val gnssCenterRegistry: GnssCenterRegistry, override val alloc: ByteBufAllocator)
  extends JT809R2011_MsgDecoder(gnssCenterRegistry, alloc) {
  override protected def getMsgBodyDecoderRegistry: JT809MsgBodyDecoderRegistry = JT809SiChuan_MsgBodyDecoderRegistry
}
