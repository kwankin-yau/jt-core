package info.gratour.jt809core.codec.decoder

import com.typesafe.scalalogging.Logger
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.types.GnssCenterSettings
import info.gratour.jtcommon.JTCodecHelper
import io.netty.buffer.ByteBuf

sealed trait MsgDecodeState

case object OK extends MsgDecodeState

final case class BadFrame(msg: String) extends MsgDecodeState

final case class InvalidGnssCenterId(gnssCenterId: Int) extends MsgDecodeState

final case class MsgDecodeResult(state: MsgDecodeState, msg: JT809Msg = null, gnssCenterSettings: GnssCenterSettings = null) {
  def ok: Boolean = state == OK
}

trait JT809MsgDecoder extends JTCodecHelper {

  protected val logger: Logger = JT809MsgDecoder.logger

  /**
   *
   * @param gnssCenterSettings initial gnss-center settings, nullable
   * @param buf The buf, is un-escaped, crc-verified, only contains header and body, does not contain the start-tag, crc, and end-tag
   * @return
   */
  def decode(gnssCenterSettings: GnssCenterSettings, buf: ByteBuf): MsgDecodeResult
}

object JT809MsgDecoder {
  private val logger = Logger[JT809MsgDecoder]
}
