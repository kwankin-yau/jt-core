package info.gratour.jt809core.codec.decoder.bodydecoder

trait JT809MsgBodyDecoderRegistry {

  def get(msgId: Int): JT809MsgBodyDecoder
}
