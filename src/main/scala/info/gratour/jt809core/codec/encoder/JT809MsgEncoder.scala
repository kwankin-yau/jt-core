package info.gratour.jt809core.codec.encoder

import java.io.Closeable

import com.typesafe.scalalogging.Logger
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.types.CryptParams
import io.netty.buffer.ByteBuf

trait JT809MsgEncoder extends Closeable{
  protected val logger: Logger = JT809MsgEncoder.logger
  def encode(m: JT809Msg, out: ByteBuf, cryptParams: CryptParams): Unit

}


object JT809MsgEncoder {
  private val logger = Logger[JT809MsgEncoder]
}
