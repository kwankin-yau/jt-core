package info.gratour.jt809core.codec.decoder.bodydecoder

import java.time.{LocalDate, LocalTime}

import com.typesafe.scalalogging.Logger
import info.gratour.common.error.{ErrorWithCode, Errors}
import info.gratour.jt809core.protocol.msg.types.JT809GnssData
import info.gratour.jt809core.protocol.{JT809FrameHeader, JT809Msg}
import info.gratour.jtcommon.{JTCodecHelper, JTUtils}
import io.netty.buffer.ByteBuf

trait JT809MsgBodyDecoder extends JTCodecHelper {


  protected val logger = Logger[JT809MsgBodyDecoder]


  def msgId: Int

  def decode(header: JT809FrameHeader, body: ByteBuf): JT809Msg

  protected val tempBuf: Array[Byte] = new Array[Byte](128)

  protected def debugPrint(buf: ByteBuf): Unit = {
    logger.whenDebugEnabled {
      logger.debug(JTUtils.byteBufToHexStringKeepReaderIndex(buf))
    }
  }


  protected def decodeGnssData(buf: ByteBuf): JT809GnssData = {
    logger.whenDebugEnabled(
      logger.debug("BEFORE decode gnss data: " + buf.remainingToHexString)
    )

    val r = new JT809GnssData
    r.setEncrypt(buf.readByte() != 0)
    val d = buf.readByte()
    val m = buf.readByte()
    val y = buf.readShort()

    r.setDate(LocalDate.of(y, m, d))
    val h = buf.readByte()
    val min = buf.readByte()
    val s = buf.readByte()
    r.setTime(LocalTime.of(h, min, s))
    val lon = buf.readInt()
    r.setLon(JTUtils.intAxisToDouble(lon))
    val lat = buf.readInt()
    r.setLat(JTUtils.intAxisToDouble(lat))
    r.setVec1(buf.readUnsignedShort())
    r.setVec2(buf.readUnsignedShort())
    r.setMileageKm(buf.readInt())
    r.setDirection(buf.readShort())
    r.setAltitude(buf.readShort())
    r.setStateBits(buf.readInt())
    r.setAlarmBits(buf.readInt())

    r
  }

  //  protected def readString(buf: ByteBuf, len: Int): String = {
  //    val bytes = new Array[Byte](len)
  //    buf.readBytes(bytes)
  //    new String(bytes, JTConsts.DEFAULT_CHARSET)
  //  }
  //
  //  protected def intLenPrefixedString(buf: ByteBuf): String = {
  //    val size = buf.readInt()
  //    readString(buf, size)
  //  }
  //
  //  protected def remainAsString(buf: ByteBuf): String = {
  //    readString(buf, buf.readableBytes())
  //  }
  //
  //  protected def fixedLenString(buf: ByteBuf, len: Int): String = {
  //    buf.readBytes(tempBuf, 0, len)
  //    JTUtils.stringMaxLen(tempBuf, 0, len)
  //  }
}

