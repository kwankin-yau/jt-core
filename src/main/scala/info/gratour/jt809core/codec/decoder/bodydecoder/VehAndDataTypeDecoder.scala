package info.gratour.jt809core.codec.decoder.bodydecoder

import info.gratour.jtcommon.JTUtils
import io.netty.buffer.ByteBuf

object VehAndDataTypeDecoder {

  /**
   * Decode a VehicleAndDataType structure from the input `buf`.
   *
   * @param buf the input buffer.
   * @param tempBuf temp buffer used for decode procedure. the tempBuf must at least 32 bytes.
   *
   * @return decoded VehicleAndDataType structure
   */
  def decode(buf: ByteBuf, tempBuf: Array[Byte]): VehAndDataType = {
    buf.readBytes(tempBuf, 0, 21)
    val vehicleNo = JTUtils.stringMaxLen(tempBuf, 0, 21)
    val vehicleColor = buf.readByte()
    val dataType = buf.readUnsignedShort()

    VehAndDataType(vehicleNo, vehicleColor, dataType)
  }
}


