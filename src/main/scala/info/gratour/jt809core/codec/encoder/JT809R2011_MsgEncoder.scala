package info.gratour.jt809core.codec.encoder

import info.gratour.jt809core.JT809Utils
import info.gratour.jt809core.codec.encoder.bodyencoder.{JT809MsgBodyEncoderRegistry, JT809R2011_MsgBodyEncoderRegistry}
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.types.CryptParams
import info.gratour.jtcommon.NettyUtils
import io.netty.buffer.{ByteBuf, ByteBufAllocator}

class JT809R2011_MsgEncoder(val byteBufAllocator: ByteBufAllocator) extends JT809MsgEncoder {

  private val bodyOut: ByteBuf = byteBufAllocator.buffer()
  private val frame: ByteBuf = byteBufAllocator.buffer()
  private val VersionFlag: Array[Byte] = Array(1, 0, 0)

  protected def getMsgBodyEncoderRegistry: JT809MsgBodyEncoderRegistry = JT809R2011_MsgBodyEncoderRegistry
  protected val msgBodyEncoderRegistry: JT809MsgBodyEncoderRegistry = getMsgBodyEncoderRegistry

  private def writeHeader(m: JT809Msg, out: ByteBuf, cryptParams: CryptParams): Unit = {
    out.writeInt(0) // size stub
    out.writeInt(m.getMsgSn)
    out.writeShort(m.getMsgId)
    out.writeInt(m.getGnssCenterId)
    out.writeBytes(VersionFlag)
    out.writeByte(if (cryptParams != null) 1 else 0)
    out.writeInt(if (cryptParams != null) cryptParams.getKey else 0)
  }



  override def encode(m: JT809Msg, out: ByteBuf, cryptParams: CryptParams): Unit = {
    val bodyEncoder = msgBodyEncoderRegistry.get(m.getMsgId)
    if (bodyEncoder == null)
      throw new RuntimeException(s"Can not encode message: ${m.msgIdHexString()}")

    frame.clear()
    writeHeader(m, frame, cryptParams)

    if (cryptParams != null) {
      bodyOut.clear()
      bodyEncoder.encodeBody(m, bodyOut)
      logger.whenTraceEnabled {
        logger.trace("Body: " + NettyUtils.bufToHex(bodyOut))
      }

      val writerIndex = frame.writerIndex()
      cryptParams.encrypt(bodyOut, bodyOut.readableBytes(), frame)
      logger.whenTraceEnabled {
        val size = frame.writerIndex() - writerIndex
        val body = frame.slice(writerIndex, size)
        logger.trace("Encrypted Body: " + NettyUtils.bufToHex(body, false))
      }
    } else {
      val writerIndex = frame.writerIndex()
      bodyEncoder.encodeBody(m, frame)
      logger.whenTraceEnabled {
        val size = frame.writerIndex() - writerIndex
        val body = frame.slice(writerIndex, size)
        logger.trace("Body: " + NettyUtils.bufToHex(body))
      }
    }

    // fill back packet size
    val size = frame.readableBytes() + 1 + 2 + 1
    frame.setInt(0, size)

    // calculate crc and append to end
    val crc = JT809Utils.crcRetainsReaderIndex(frame)
    frame.writeShort(crc)

    out.writeByte(0x5B)
    // escape
    while (frame.isReadable) {
      val b = frame.readByte()
      b match {
        case 0x5B =>
          out.writeShort(0x5A01)
        case 0x5A =>
          out.writeShort(0x5A02)
        case 0x5D =>
          out.writeShort(0x5E01)
        case 0x5E =>
          out.writeShort(0x5E02)
        case _ =>
          out.writeByte(b)
      }
    }
    out.writeByte(0x5D)
  }

  override def close(): Unit = {
    bodyOut.release()
  }
}


