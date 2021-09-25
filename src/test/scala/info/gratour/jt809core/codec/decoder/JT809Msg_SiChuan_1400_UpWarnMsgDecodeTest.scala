package info.gratour.jt809core.codec.decoder
import info.gratour.jt809core.protocol.msg.warn.JT809UpWarnMsg
import info.gratour.jt809core.{Packet, TestPackets}
import org.junit.Test


class JT809Msg_SiChuan_1400_UpWarnMsgDecodeTest extends SiChuan809MsgDecoderTest {
  override val packet: Packet = TestPackets.packetOf(JT809UpWarnMsg.MSG_ID)



  @Test
  def test(): Unit = {
    testDecode()

    testDecode("5b0000005a01000000241400000023200100000000000000010214000000005e020872f0633764613761356262356166343237643965663733626236386235623061636100000200000000000000000000005000500000000000b9905d")
  }
}
