package info.gratour.jt809core.codec.decoder

import info.gratour.jt809core.protocol.msg.exg.JT809UpExgMsg
import info.gratour.jt809core.{Packet, TestPackets}
import org.junit.Test

class JT809Msg_1200_UpExgMsgDecodeTest extends MsgDecoderTest {

  @Test
  def test(): Unit = {
    testDecode()
  }

  override val packet: Packet = TestPackets.packetOf(JT809UpExgMsg.MSG_ID)
}
