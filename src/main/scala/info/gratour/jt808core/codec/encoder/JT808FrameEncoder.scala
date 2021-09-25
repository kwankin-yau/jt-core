package info.gratour.jt808core.codec.encoder

import info.gratour.common.utils.BcdUtils
import info.gratour.jt808core.protocol.JT808Msg
import io.netty.buffer.ByteBuf
import org.apache.commons.lang3.StringUtils

object JT808FrameEncoder {

  private def escapeByte(b: Byte, out: ByteBuf): Unit = {
    b match {
      case 0x7e =>
        out.writeShort(0x7d02)

      case 0x7d =>
        out.writeShort(0x7d01)

      case _ =>
        out.writeByte(b)
    }
  }

  /**
   * Encode message to frames. The encoded frame are crc-calculated and escaped.
   *
   * @param seqNumAllocator message sequence number allocator.
   * @param m               message to encode
   * @param bodyEncoder     message body encoder
   * @param tempBuf         content in tempBuf will be clear
   * @param out             output buffer
   * @return packet/fragment count. One message may produce 1 or more packets, 1 packet may produce 1 or more fragments. This count is count in fragment.
   */
  def encode(seqNumAllocator: SeqNumAllocator, m: JT808Msg, bodyEncoder: JT808MsgBodyEncoder, tempBuf: ByteBuf, out: ByteBuf): Int = {


    def calcCrcAndEscape(buf: ByteBuf): Unit = {
      out.writeByte(0x7E)
      var count = buf.readableBytes
      var crc = 0

      while (count > 0) {
        val b = buf.readByte
        crc ^= b
        escapeByte(b, out)
        count -= 1
      }
      escapeByte(crc.toByte, out)
      out.writeByte(0x7E)
    }

    val msgId = m.getMsgId
    val simNo = m.getSimNo
    val seqNo = m.getSeqNo
    tempBuf.clear
    tempBuf.writeShort(msgId) // message id

    tempBuf.writeShort(0) // attributes

    val canonicalSimNum = if (simNo.length > 12) simNo.substring(0, 12)
    else if (simNo.length < 12) StringUtils.leftPad(simNo, 12, '0')
    else simNo

    val simNoBcd = BcdUtils.encode(canonicalSimNum)
    tempBuf.writeBytes(simNoBcd)

    tempBuf.writeShort(seqNo)
    val index = tempBuf.writerIndex
    bodyEncoder.encBody(m, tempBuf)
    val index2 = tempBuf.writerIndex
    val bodySize = index2 - index
    if (bodySize > 1023) {
      val body = tempBuf.slice(index, bodySize)
      var sz = bodySize
      var fragmentCount = bodySize / 1023
      if (bodySize % 1023 != 0)
        fragmentCount += 1

      var fragmentIndex = 1
      val temp2 = tempBuf.alloc().buffer()
      try {
        var first = true
        while (sz > 0) {
          val blockSz =
            if (sz > 1023)
              1023
            else
              sz


          temp2.clear()
          temp2.writeShort(msgId) // message id
          temp2.writeShort(0) // attributes

          // simNo
          temp2.writeBytes(simNoBcd)

          // seq-no
          if (first) {
            temp2.writeShort(seqNo)
            first = false
          } else
            temp2.writeShort(seqNumAllocator.nextSeqNo())

          // fragment
          temp2.writeShort(fragmentCount)
          temp2.writeShort(fragmentIndex)

          temp2.writeBytes(body, blockSz)

          val flags = blockSz | (1 << 13)
          temp2.setShort(2, flags)

          calcCrcAndEscape(temp2)


          fragmentIndex += 1
          sz -= blockSz
        }
      } finally {
        temp2.release()
      }

      fragmentCount
    } else {
      tempBuf.setShort(2, bodySize)

      calcCrcAndEscape(tempBuf)
//      out.writeByte(0x7E)
//      var count = tempBuf.readableBytes
//      var crc = 0
//
//      while (count > 0) {
//        val b = tempBuf.readByte
//        crc ^= b
//        escapeByte(b, out)
//        count -= 1
//      }
//      escapeByte(crc.toByte, out)
//      out.writeByte(0x7E)
      1
    }


  }

}
