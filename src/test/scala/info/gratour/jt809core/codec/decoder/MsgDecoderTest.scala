package info.gratour.jt809core.codec.decoder

import info.gratour.jt809core.{GnssCenterRegistryTestImpl, Packet, TestLogger}
import info.gratour.jtcommon.JTCodecHelper
import io.netty.buffer.{ByteBuf, ByteBufAllocator, PooledByteBufAllocator}
import org.apache.commons.codec.binary.Hex

trait MsgDecoderTest extends JTCodecHelper {

  val byteBufAllocator: ByteBufAllocator = PooledByteBufAllocator.DEFAULT
  val byteBuf: ByteBuf = byteBufAllocator.buffer()

  val msgDecoder: JT809MsgDecoder = new JT809R2011_MsgDecoder(GnssCenterRegistryTestImpl, byteBufAllocator)

  val packet: Packet

  def testDecode(): Unit = {
    byteBuf.clear()
    byteBuf.writeBytes(Hex.decodeHex(packet.packet))

    TestLogger.logger.debug(s"PACKET: (${byteBuf.readableBytes()}): " + packet.packet)

    val frameDecoder = new JT809FrameDecoder(byteBufAllocator)
    val buffers = frameDecoder.decode(byteBuf)

    for (buf <- buffers) {
      TestLogger.logger.debug(s"Before decode message(${buf.readableBytes()}): " + buf.remainingToHexString)
      val dr = msgDecoder.decode(null, buf)
      if (dr.ok) {
        TestLogger.logger.debug(s"DECODED : ${dr.msg}.")
      } else {
        TestLogger.logger.debug("DECODE FAILED: " + packet.packet + ".")
      }
    }
  }

  def testDecode(packetHex: String): Unit = {
    byteBuf.clear()
    byteBuf.writeBytes(Hex.decodeHex(packetHex))

    TestLogger.logger.debug(s"PACKET: (${byteBuf.readableBytes()}): " + packetHex)

    val frameDecoder = new JT809FrameDecoder(byteBufAllocator)
    val buffers = frameDecoder.decode(byteBuf)

    for (buf <- buffers) {
      TestLogger.logger.debug(s"Before decode message(${buf.readableBytes()}): " + buf.remainingToHexString)
      val dr = msgDecoder.decode(null, buf)
      if (dr.ok) {
        TestLogger.logger.debug(s"DECODED : ${dr.msg}.")
      } else {
        TestLogger.logger.debug("DECODE FAILED: " + packetHex + ".")
      }
    }
  }

}
