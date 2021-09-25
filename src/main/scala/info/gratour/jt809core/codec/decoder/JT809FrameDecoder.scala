package info.gratour.jt809core.codec.decoder

import java.io.Closeable

import com.typesafe.scalalogging.Logger
import info.gratour.jt809core.JT809Utils
import io.netty.buffer.{ByteBuf, ByteBufAllocator}

import scala.collection.mutable.ArrayBuffer

private[this] sealed trait ParseState

private[this] case object Start5B extends ParseState

private[this] case object Escaping5A extends ParseState

private[this] case object Escaping5E extends ParseState

private[this] case object ExpectEnd5D extends ParseState

class JT809FrameDecoder(val alloc: ByteBufAllocator) extends Closeable {


  private val logger = Logger("JT809FrameDecoder")

  private var tempBuf = alloc.buffer()
  private var parseState: ParseState = Start5B

  /**
   * Do a CRC verification on given input `buf`.
   *
   * @param buf contains only header, body and crc, does not contains start-tag and end-tag.
   * @return header and body, does not contains start-tag, crc and end-tag. null if error. If verification success,
   *         the input `buf` will be retained for the returned header and body slice.
   */
  private def verifyCrc(buf: ByteBuf): ByteBuf = {
    val readerIndex = buf.readerIndex()

    val crcOffset = readerIndex + buf.readableBytes() - 2;
    val crc = buf.getUnsignedShort(crcOffset)
    val headerAndBody = buf.slice(readerIndex, crcOffset)
    val calculatedCrc = JT809Utils.crc(headerAndBody)

    buf.readerIndex(readerIndex)

    val r = crc == calculatedCrc
    if (!r) {
      logger.debug(s"CRC verification failed, expected: ${crc.toHexString}, got: ${calculatedCrc.toHexString}")
    }

    if (r) {
      headerAndBody.readerIndex(0)
      headerAndBody.retain()
    } else
      null
  }

  private val EMPTY = new Array[ByteBuf](0)

  /**
   * Do a continuously decode operation on `buf`. After method invocation, the `buf` DOES NOT be release. The caller is
   * responsible to `release` the `buf`, if needed.
   *
   * @param buf
   * @return parsed frames, null if error, empty array if there is no integrity frame received yet. If error, the caller
   *         should close the connection.
   */
  def decode(buf: ByteBuf): Array[ByteBuf] = {
    var decodedFrames: ArrayBuffer[ByteBuf] = null

    while (buf.isReadable) {
      val b = buf.readByte()
      parseState match {
        case Start5B =>
          if (b == 0x5B) {
            parseState = ExpectEnd5D
          }
        // else, discard it

        case ExpectEnd5D =>
          if (b == 0x5D) {
            val headerAndBody = verifyCrc(tempBuf)
            if (headerAndBody == null) {
              tempBuf.clear()
            } else {
              if (decodedFrames == null)
                decodedFrames = ArrayBuffer(headerAndBody)
              else
                decodedFrames += headerAndBody

              tempBuf.release()
              tempBuf = alloc.buffer()
            }
            parseState = Start5B
          } else if (b == 0x5A) {
            parseState = Escaping5A
          } else if (b == 0x5E) {
            parseState = Escaping5E
          } else
            tempBuf.writeByte(b)

        case Escaping5A =>
          b match {
            case 0x01 =>
              tempBuf.writeByte(0x5B)
              parseState = ExpectEnd5D

            case 0x02 =>
              tempBuf.writeByte(0x5A)
              parseState = ExpectEnd5D

            case _ =>
              // bad frame
              logger.debug("Bad escaping, expect 0x01 or 0x02, but got: " + b.toHexString + ".")
              return null
          }

        case Escaping5E =>
          b match {
            case 0x01 =>
              tempBuf.writeByte(0x5D)
              parseState = ExpectEnd5D

            case 0x02 =>
              tempBuf.writeByte(0x5E)
              parseState = ExpectEnd5D

            case _ =>
              logger.debug("Bad escaping, expect 0x01 or 0x02, but got: " + b.toHexString + ".")
              return null
          }
      }
    }

    if (decodedFrames == null)
      EMPTY
    else
      decodedFrames.toArray
  }

  override def close(): Unit = {
    tempBuf.release()
  }

}
