package info.gratour.jt809core.codec.decoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1008_UpCloseLinkInform
import info.gratour.jt809core.{Packet, TestPackets}
import org.junit.Test

class JT809Msg_1008_UpCloseLinkInformDecodeTest extends MsgDecoderTest {

  override val packet: Packet = TestPackets.packetOf(JT809Msg_1008_UpCloseLinkInform.MSG_ID)

  @Test
  def test(): Unit = {
    testDecode()
  }
}
