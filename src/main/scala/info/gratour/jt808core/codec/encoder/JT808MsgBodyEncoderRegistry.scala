package info.gratour.jt808core.codec.encoder

trait JT808MsgBodyEncoderRegistry {

  def get(msgId: Int): JT808MsgBodyEncoder
}
