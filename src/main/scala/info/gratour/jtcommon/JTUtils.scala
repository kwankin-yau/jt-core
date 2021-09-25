package info.gratour.jtcommon

import java.text.DecimalFormat
import java.time.LocalDateTime
import java.util

import com.typesafe.scalalogging.Logger
import info.gratour.common.error.{ErrorWithCode, Errors}
import info.gratour.common.utils.BcdUtils
import info.gratour.jt808core.protocol.msg.{JT808Msg_0100_TerminalRegister, JT808Msg_8103_SetParam}
import info.gratour.jtmodel.Coordinate
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex
import org.apache.commons.lang3.StringUtils


object JTUtils {

  private val logger = Logger(JTUtils.getClass)

  def jtMsgIdOf(msgClass: Class[_]): Int = {
    val annotation = msgClass.getAnnotation(classOf[JTMsgId]);
    if (annotation == null) {
      val errMsg = s"The class $msgClass has no JTMsgId annotation definition."
      logger.error(errMsg)
      throw new RuntimeException(errMsg)
    }

    annotation.value()
  }

  case class MsgAckInfo(withSeqNo: Boolean)



  val MsgAckInfoMap: Map[String, MsgAckInfo] = {
    def e(msgId: String, withSeqNo: Boolean = true): (String, MsgAckInfo) =
      msgId -> MsgAckInfo(withSeqNo)

    Map(
      // jt808
      e("8103"),
      e("8104"),
      e("8106"),
      e("8105"),
      e("8107", false),
      e("8108"),
      e("8201"),
      e("8202"),
      e("8300"),
      e("8301"),
      e("8302"),
      e("8303"),
      e("8304"),
      e("8400"),
      e("8401"),
      e("8500"),
      e("8600"),
      e("8601"),
      e("8602"),
      e("8603"),
      e("8604"),
      e("8605"),
      e("8606"),
      e("8607"),
      e("8700"),
      e("8701"),
      e("8702", false),
      e("8801"),
      e("8802"),
      e("8803"),
      e("8804"),
      e("8805"),

      // jt1078
      e("9003", false),
      e("9101"),
      e("9102"),
      e("9205"),
      e("9201"),
      e("9202"),
      e("9206"),
      e("9207"),
      e("9301"),
      e("9302"),
      e("9303"),
      e("9304"),
      e("9305"),
      e("9306"),

      // si-chuan ADAS
      e("9208")
    )
  }

  def msgHasAck(msgId: String): Boolean = MsgAckInfoMap.contains(msgId)

  def isMsgAckWithSeqNo(msgId: String): Boolean = MsgAckInfoMap.get(msgId).exists(_.withSeqNo)


  /**
   * Use info.gratour.jtcommon.NettyUtils#byteBufToHexStringKeepReaderIndex(io.netty.buffer.ByteBuf) instead
   *
   * @param buf
   * @return
   */
  @Deprecated
  def byteBufToHexStringKeepReaderIndex(buf: ByteBuf): String = {
    val readerIndex = buf.readerIndex
    val size = buf.readableBytes
    val bytes = new Array[Byte](size)
    buf.readBytes(bytes)
    buf.readerIndex(readerIndex)
    Hex.encodeHexString(bytes)
  }

  def stringMaxLen(bytes: Array[Byte], offset: Int, maxLen: Int): String = {
    var l = maxLen
    var break: Boolean = false
    for (i <- 0 until maxLen if !break) {
      val b = bytes(i + offset)
      if (b == 0) {
        l = i
        break = true
      }
    }

    new String(bytes, offset, l, JTConsts.DEFAULT_CHARSET)
  }

  val AxisFormatter: DecimalFormat = new DecimalFormat("0.000000")

  def formatAxis(axis: Double): String = AxisFormatter.format(axis)

  def intAxisToDouble(axis: Int): Double = axis / 1000000d

  def doubleAxisToInt(axis: Double): Int = (axis * 1000000).toInt

  def intToHex(value: Int, digits: Int, prepend0x: Boolean): String = {
    var v = Integer.toHexString(value)
    if (v.length < digits) v = StringUtils.leftPad(v, digits, '0')
    if (prepend0x) v = "0x" + v
    v
  }

  def intToHex(value: Int, digits: Int): String = intToHex(value, digits, prepend0x = false)

  def msgIdToHex(msgId: Int): String = intToHex(msgId, 4, false)

  /**
   * Use info.gratour.common.utils.StringUtils#strLen(byte[]) instead
   *
   * @param bytes
   * @return
   */
  @Deprecated
  def strLen(bytes: Array[Byte]): Int = {
    for (i <- bytes.indices) {
      val b = bytes(i)
      if (b == 0)
        return i;
    }

    bytes.length
  }

  def cStr(bytes: Array[Byte]): String = {
    val len = info.gratour.common.utils.StringUtils.strLen(bytes)
    new String(bytes, 0, len, JTConsts.DEFAULT_CHARSET)
  }

  def cStr(bytes: Array[Byte], maxLen: Int): String = {
    val len = info.gratour.common.utils.StringUtils.strLen(bytes, maxLen)
    new String(bytes, 0, len, JTConsts.DEFAULT_CHARSET)
  }


  def bitTest(value: Int, bitIndex: Int): Boolean = (value & (1 << bitIndex)) != 0

  //  private val SIM_NO_REGEX: Regex = "\\d{11,12}".r

  def isValidSimNo(simNo: String): Boolean = {
    //    (simNo != null) && SIM_NO_REGEX.pattern.matcher(simNo).matches()

    if (simNo == null)
      return false

    val l = simNo.length
    if (l < 11 || l > 12)
      return false

    (0 until l).foreach(i => {
      val c = simNo.charAt(i)
      if (c < '0' || c > '9')
        return false
    })

    true
  }

  def normalizeSimNo(simNo: String): String =
    if (simNo.indexOf('0') == 0)
      simNo.substring(1)
    else
      simNo

  def decodeBcdDateTime(bytes: Array[Byte]): LocalDateTime = {
    val s = BcdUtils.decode(bytes, 0, 6)
    LocalDateTime.parse(s, JTConsts.BCD_DATE_TIME_FORMATTER)
  }

  private def decodeXY(s: String): Coordinate = {
    val xy = s.split(" ")
    if (xy.size < 2)
      return null
    new Coordinate(xy(0).toDouble, xy(1).toDouble)
  }

  private val POINT_PREFIX = "POINT("
  private val POINT_PREFIX_LEN = POINT_PREFIX.length

  def decodeWKTPoint(wktPoint: String): Coordinate = {
    if (wktPoint == null)
      null
    else {
      val pStart = wktPoint.indexOf(POINT_PREFIX)
      if (pStart < 0)
        return null
      val pEnd = wktPoint.indexOf(')', pStart + 1)
      if (pEnd <= pStart)
        return null

      val s = wktPoint.substring(pStart + POINT_PREFIX_LEN, pEnd)
      decodeXY(s)
    }
  }

  def encodeWKTPoint(coord: Coordinate): String =
    s"SRID=4326;POINT(${coord.lngStr()} ${coord.latStr()})"

  private val POLY_LEFT_PAREN = 1
  private val POLY_X = 2
  private val POLY_X_OR_SPACE = 3
  private val POLY_Y = 4

  private def internalDecodePolygon(s: String): java.util.List[java.util.List[Coordinate]] = {
    var st = POLY_LEFT_PAREN
    var i = 0
    var numStart = 0
    var x: Double = 0d
    var y: Double = 0d
    val r = new util.ArrayList[java.util.List[Coordinate]]()
    var currPolygon: util.ArrayList[Coordinate] = null

    val last = s.length - 1
    for (i <- 0 to last) {
      val c = s.charAt(i)

      st match {
        case POLY_LEFT_PAREN =>
          if (c == '(') {
            currPolygon = new util.ArrayList[Coordinate]()
            r.add(currPolygon)
            st = POLY_X
            numStart = i + 1
          }

        case POLY_X =>
          c match {
            case '+' | '-' | '.' =>
            case _ =>
              if (c == ' ') {
                val num = s.substring(numStart, i)
                x = num.toDouble
                st = POLY_Y
                numStart = i + 1
              } else if (!Character.isDigit(c))
                throw new ErrorWithCode(Errors.BAD_FORMAT, s"Invalid polygon `$s`.")
          }

        case POLY_X_OR_SPACE =>
          c match {
            case '+' | '-' | '.' =>
              if (numStart == -1) {
                numStart = i
                st = POLY_X
              }

            case ' ' =>
            case _ =>
              if (!Character.isDigit(c))
                throw new ErrorWithCode(Errors.BAD_FORMAT, s"Invalid polygon `$s`.")
              else {
                if (numStart == -1) {
                  numStart = i
                  st = POLY_X
                }
              }
          }

        case POLY_Y =>
          c match {
            case '+' | '-' | '.' =>
            case ')' =>
              val num = s.substring(numStart, i)
              y = num.toDouble
              val coord = new Coordinate(x, y)
              currPolygon.add(coord)

              st = POLY_LEFT_PAREN
            case ',' =>
              val num = s.substring(numStart, i)
              y = num.toDouble
              val coord = new Coordinate(x, y)
              currPolygon.add(coord)
              st = POLY_X_OR_SPACE
              numStart = -1
            case _ =>
              if (!Character.isDigit(c))
                throw new ErrorWithCode(Errors.BAD_FORMAT, s"Invalid polygon `$s`.")
          }
      }
    }

    r
  }

  private val POLYGON_PREFIX = "POLYGON("
  private val POLYGON_PREFIX_LEN = POLYGON_PREFIX.length

  def decodeWKTPolygon(wktPolygon: String): java.util.List[java.util.List[Coordinate]] = {
    if (wktPolygon == null)
      null
    else {
      val pStart = wktPolygon.indexOf(POLYGON_PREFIX)
      if (pStart < 0)
        return null

      val pEnd = wktPolygon.lastIndexOf(')')
      if (pEnd <= pStart)
        return null

      val s = wktPolygon.substring(pStart + POLYGON_PREFIX_LEN, pEnd)
      internalDecodePolygon(s)
    }
  }

  def decodeSimpleWKTPolygon(wktPolygon: String): java.util.List[Coordinate] = {
    if (wktPolygon == null)
      return null

    val ll = decodeWKTPolygon(wktPolygon)
    if (ll == null)
      return null

    if (ll.size() != 1) {
      throw new ErrorWithCode(Errors.BAD_FORMAT, s"Not a simple polygon `$wktPolygon`.")
    }

    ll.get(0)
  }

  def encodeWKTPolygon(vectors: java.util.List[Coordinate]): String = {
    val s = new java.lang.StringBuilder("SRID=4326;POLYGON((")
    for (i <- 0 until vectors.size()) {
      val coord = vectors.get(i)
      if (i > 0)
        s.append(',')
      s.append(coord.lngStr()).append(' ').append(coord.latStr())
    }
    s.append("))")
    s.toString
  }

}
