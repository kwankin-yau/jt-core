package info.gratour.jt809core

object TestPackets {

  val packets: Map[Int, Packet] = Seq(
    Packet(0x1001, "5b00000048000000011001000023200001e000000000000000232031323334353637383132372e302e302e310000000000000000000000000000000000000000000000303951b95d"),
    Packet(0x1008, "5b0000001b000000041008000023200001e0000000000000dfe75d"),
    Packet(0x1200, "5b0000005a02000000021200000023200001e00000000000b2e2413030303033000000000000000000000000000212020000002400180c07e3111920071ee64c018c4c830000001700000000000000000000020100000000fd405d"),
    Packet(0x1400, "5B000000770000000E1400000023200100000000000000B2E24130303030330000000000000000000000000002140200000041010000000000005E0202DB26646364366664616333613132343061323836373762633139323830643835373100000200000000000000000000005000000000000000C15E025D")
  ).map(p => (p.msgId -> p)).toMap

  def packetOf(msgId: Int): Packet = packets.get(msgId).orNull

}

case class Packet(msgId: Int, packet: String)
