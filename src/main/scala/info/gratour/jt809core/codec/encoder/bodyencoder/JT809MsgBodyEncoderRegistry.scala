package info.gratour.jt809core.codec.encoder.bodyencoder

trait JT809MsgBodyEncoderRegistry {

  def get(msgId: Int): MsgBodyEncoder
}
