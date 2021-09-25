/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core

import com.typesafe.scalalogging.Logger
import info.gratour.common.utils.StringUtils
import info.gratour.jt808core.codec.decoder.{JT808FrameDecoder, JT808MsgDecoder_SiChuan}
import io.netty.buffer.UnpooledByteBufAllocator

trait JT808DecodeTest {

  def logger: Logger = JT808DecodeTest._logger

  def doTest(hexPacketData: String): Unit = {
    val alloc = UnpooledByteBufAllocator.DEFAULT
    val frameDecoder = new JT808FrameDecoder(alloc)
    val decodeTempBuff: Array[Byte] = new Array[Byte](128)
    val bytes = StringUtils.hex(hexPacketData)
    val buff = alloc.buffer(bytes.length)
    buff.writeBytes(bytes)

    val frame = frameDecoder.decodeFrame(buff, decodeTempBuff)
    val msg = JT808MsgDecoder_SiChuan.decode(frame, decodeTempBuff)
    logger.debug(s"Decoded msg: $msg")
  }
}

object JT808DecodeTest {
  private val _logger: Logger = Logger[JT808DecodeTest]
}
