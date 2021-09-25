package info.gratour.jt809core.codec.decoder

import info.gratour.jt809core.{Packet, TestPackets}
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1001_UpConnectReq
import org.junit.Test


class JT809Msg_1001_UpConnectReqDecodeTest extends MsgDecoderTest {


  @Test
  def test(): Unit = {
    testDecode()
  }

  override val packet: Packet = TestPackets.packetOf(JT809Msg_1001_UpConnectReq.MSG_ID)
}
