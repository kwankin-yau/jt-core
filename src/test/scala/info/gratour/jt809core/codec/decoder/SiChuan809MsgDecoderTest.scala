package info.gratour.jt809core.codec.decoder
import info.gratour.jt809core.GnssCenterRegistryTestImpl

trait SiChuan809MsgDecoderTest extends MsgDecoderTest {
  override val msgDecoder: JT809MsgDecoder = new JT809SiChuan_MsgDecoder(GnssCenterRegistryTestImpl, byteBufAllocator)
}
