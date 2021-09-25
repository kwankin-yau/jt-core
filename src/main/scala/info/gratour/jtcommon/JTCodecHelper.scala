/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jtcommon

import java.time.{LocalDate, LocalTime}

import info.gratour.common.utils.BcdUtils
import info.gratour.jt808core.codec.CodecError
import info.gratour.jt809core.protocol.msg.types.JT809GnssData
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

trait JTCodecHelper {

  def notSupportedDataType(dataType: Int): CodecError = new CodecError(s"Not supported data type: $dataType.")
  def notSupportedMsgType(msgType: Class[_]): CodecError = new CodecError(s"Not supported message type: ${msgType.getName}.")

  def intAxisToDouble(axis: Int): Double = JTUtils.intAxisToDouble(axis)

  def doubleAxisToInt(axis: Double): Int = JTUtils.doubleAxisToInt(axis)

  protected def checkNotNull[A](o: A, propName: String): A = {
    if (o == null)
      throw new CodecError(s"`$propName` == null")

    o
  }

  protected def checkNotEmpty[A](o: Array[A], propName: String): Array[A] = {
    if (o == null)
      throw new CodecError(s"`$propName` == null")
    if (o.isEmpty)
      throw new CodecError(s"`$propName` is empty")

    o
  }


  implicit class ByteBuf809Helper(byteBuf: ByteBuf) {

    def readGnssData: JT809GnssData = {
      val r = new JT809GnssData
      r.setEncrypt(byteBuf.readByte() != 0)

      val d = byteBuf.readByte()
      val m = byteBuf.readByte()
      val y = byteBuf.readByte()
      r.setDate(LocalDate.of(y, m, d))

      val h = byteBuf.readByte()
      val min = byteBuf.readByte()
      val s = byteBuf.readByte()
      r.setTime(LocalTime.of(h, min, s))

      r.setLon(intAxisToDouble(byteBuf.readInt()))
      r.setLat(intAxisToDouble(byteBuf.readInt()))

      r.setVec1(byteBuf.readUnsignedShort())
      r.setVec2(byteBuf.readUnsignedShort())

      r.setMileageKm(byteBuf.readInt())
      r.setDirection(byteBuf.readShort())
      r.setAltitude(byteBuf.readShort())

      r.setStateBits(byteBuf.readInt())
      r.setAlarmBits(byteBuf.readInt())

      r
    }

    def writeGnssData(gnssData: JT809GnssData): Unit = {
      if (gnssData == null)
        return

      byteBuf.writeByte(if (gnssData.isEncrypt) 1 else 0)
      val date = gnssData.getDate
      byteBuf.writeByte(date.getDayOfMonth)
      byteBuf.writeByte(date.getMonthValue)
      byteBuf.writeShort(date.getYear)

      val time = gnssData.getTime
      byteBuf.writeByte(time.getHour)
      byteBuf.writeByte(time.getMinute)
      byteBuf.writeByte(time.getSecond)

      byteBuf.writeInt(doubleAxisToInt(gnssData.getLon))
      byteBuf.writeInt(doubleAxisToInt(gnssData.getLat))

      byteBuf.writeShort(gnssData.getVec1)
      byteBuf.writeShort(gnssData.getVec2)

      byteBuf.writeInt(gnssData.getMileageKm)
      byteBuf.writeShort(gnssData.getDirection)
      byteBuf.writeShort(gnssData.getAltitude)

      byteBuf.writeInt(gnssData.getStateBits)
      byteBuf.writeInt(gnssData.getAlarmBits)
    }

    def readTimestamp: Long = byteBuf.readLong()

    def writeTimestamp(ts: Long): Unit = byteBuf.writeLong(ts)

    def convertToByteArray: Array[Byte] = {
      if (byteBuf.hasArray)
        byteBuf.array()
      else {
        val readerIndex = byteBuf.readerIndex()
        byteBuf.readerIndex(0)
        val r = new Array[Byte](byteBuf.readableBytes())
        byteBuf.readBytes(r)
        byteBuf.readerIndex(readerIndex)
        r
      }
    }

    def remainingToHexString: String = {
      val size = byteBuf.readableBytes()
      if (size > 0) {
        val bytes = new Array[Byte](size)
        val readerIndex = byteBuf.readerIndex()
        byteBuf.readBytes(bytes)
        byteBuf.readerIndex(readerIndex)
        Hex.encodeHexString(bytes)
      } else
        ""
    }

    def readBytesLen(len: Int): Array[Byte] = {
      val r = new Array[Byte](len)
      byteBuf.readBytes(r)
      r
    }

    def readStr(len: Int): String = {
      val bytes = new Array[Byte](len)
      byteBuf.readBytes(bytes)
      new String(bytes, JTConsts.DEFAULT_CHARSET)
    }

    def readStrMaxLen(maxLen: Int): String = {
      val bytes = new Array[Byte](maxLen)
      byteBuf.readBytes(bytes)

      JTUtils.stringMaxLen(bytes, 0, maxLen)
    }

    def readRemainingAsStr(): String = {
      val size = byteBuf.readableBytes()
      if (size > 0)
        readStr(size)
      else
        ""
    }

    private val EMPTY_BYTE_ARRAY: Array[Byte] = new Array[Byte](0)

    def readRemainingAsBytes(): Array[Byte] = {
      val size = byteBuf.readableBytes()
      if (size > 0) {
        val r = new Array[Byte](size)
        byteBuf.readBytes(r)
        r
      }
      else
        EMPTY_BYTE_ARRAY
    }

    def readByteLenPrefixedStr(): String = {
      val size = byteBuf.readUnsignedByte()
      readStr(size)
    }

    def readShortLenPrefixedStr(): String = {
      val size = byteBuf.readUnsignedShort()
      readStr(size)
    }

    def readIntLenPrefixedStr(): String = {
      val size = byteBuf.readInt()
      readStr(size)
    }

    def readBcd(bytes: Int): String = {
      val buf = new Array[Byte](bytes)
      byteBuf.readBytes(buf)
      BcdUtils.decode(buf)
    }

    def readAxis(): Double = {
      val i: Double = byteBuf.readInt()
      i / 1000000d
    }

    def writeStr(s: String): Unit = {
      if (s != null) {
        val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
        byteBuf.writeBytes(bytes)
      }
    }

    def writeFixedLenStr(s: String, len: Int): Unit = {
      if (s == null || s.isEmpty) {
        byteBuf.writeZero(len)
        return
      }

      val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
      val l = bytes.length
      if (l > len) {
        throw new RuntimeException(s"String `$s` is too long(limit=$len).")
      }

      byteBuf.writeBytes(bytes)
      val delta = len - l
      if (delta > 0)
        byteBuf.writeZero(delta)
    }

    def writeFixedLenBytes(bytes: Array[Byte], len: Int): Unit = {
      if (bytes == null || bytes.isEmpty) {
        byteBuf.writeZero(len)
        return
      }

      val l = bytes.length
      if (l > len) {
        throw new RuntimeException(s"Bytes `$bytes` is too long(limit=$len).")
      }

      byteBuf.writeBytes(bytes)
      val delta = len - l
      if (delta > 0)
        byteBuf.writeZero(delta)
    }

    def writeByteLenPrefixedStr(s: String): Unit = {
      if (s == null || s.isEmpty) {
        byteBuf.writeByte(0)
        return
      }

      val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
      byteBuf.writeByte(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeShortLenPrefixedStr(s: String): Unit = {
      if (s == null || s.isEmpty) {
        byteBuf.writeShort(0)
        return
      }

      val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
      byteBuf.writeShort(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeIntLenPrefixedStr(s: String): Unit = {
      if (s == null || s.isEmpty) {
        byteBuf.writeInt(0)
        return
      }

      val bytes = s.getBytes(JTConsts.DEFAULT_CHARSET)
      byteBuf.writeInt(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeByteLenPrefixedBytes(bytes: Array[Byte]): Unit = {
      if (bytes == null || bytes.isEmpty) {
        byteBuf.writeByte(0)
        return
      }

      byteBuf.writeByte(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeShortLenPrefixedBytes(bytes: Array[Byte]): Unit = {
      if (bytes == null || bytes.isEmpty) {
        byteBuf.writeShort(0)
        return
      }

      byteBuf.writeShort(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeIntLenPrefixedBytes(bytes: Array[Byte]): Unit = {
      if (bytes == null || bytes.isEmpty) {
        byteBuf.writeInt(0)
        return
      }

      byteBuf.writeInt(bytes.length)
      byteBuf.writeBytes(bytes)
    }

    def writeBcd(s: String): Unit = {
      val bytes = BcdUtils.encode(s)
      byteBuf.writeBytes(bytes)
    }

    def writeAxis(axis: Double): Unit = {
      val i = (axis * 1000000).toInt
      byteBuf.writeInt(i)
    }
  }

}
