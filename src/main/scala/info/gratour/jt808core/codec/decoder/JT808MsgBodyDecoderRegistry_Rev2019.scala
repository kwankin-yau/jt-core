package info.gratour.jt808core.codec.decoder

import info.gratour.jt808core.codec.decoder.impl.MBDecoder808_0001_DeviceGeneralAck

object JT808MsgBodyDecoderRegistry_Rev2019 extends JT808MsgBodyDecoderRegistry {

  private val map: Map[Int, JT808MsgBodyDecoder[_]] = Seq(
    MBDecoder808_0001_DeviceGeneralAck
  ).map(d => (d.msgId -> d)).toMap


  override def get(msgId: Int): JT808MsgBodyDecoder[_] = map.get(msgId).orNull
}
