package info.gratour.jt809core.codec.decoder

import info.gratour.jt809core.JT809Utils
import info.gratour.jt809core.codec.decoder.bodydecoder.{JT809MsgBodyDecoderRegistry, JT809R2011_MsgBodyDecoderRegistry}
import info.gratour.jt809core.protocol.{JT809FrameHeader, JT809Msg, VersionFlag}
import info.gratour.jt809core.types.{CryptSettings, GnssCenterRegistry, GnssCenterSettings}
import info.gratour.jtcommon.NettyUtils
import io.netty.buffer.{ByteBuf, ByteBufAllocator}


case class MsgHeaderDecodeResult(state: MsgDecodeState, header: JT809FrameHeader = null, gnssCenterSettings: GnssCenterSettings = null) {
  def ok: Boolean = state == OK
}

class JT809R2011_MsgDecoder(val gnssCenterRegistry: GnssCenterRegistry, val alloc: ByteBufAllocator) extends JT809MsgDecoder {

  private val HEADER_SIZE = (4 + 4 + 2 + 4 + 3 + 1 + 4)
  private val MIN_PACKET_SIZE = 1 + HEADER_SIZE + 2 + 1

  private val tempBuf: Array[Byte] = new Array[Byte](128)

  private def decrypt(key: Int, cryptParam: CryptSettings, input: ByteBuf, size: Int, output: ByteBuf): Unit =
    JT809Utils.decrypt(key, cryptParam.getM, cryptParam.getIa, cryptParam.getIc, input, size, output)

  protected def getMsgBodyDecoderRegistry: JT809MsgBodyDecoderRegistry = JT809R2011_MsgBodyDecoderRegistry

  protected val msgBodyDecoderRegistry: JT809MsgBodyDecoderRegistry = getMsgBodyDecoderRegistry

  protected def decodeHeader(gnssCenterSettings: GnssCenterSettings, buf: ByteBuf): MsgHeaderDecodeResult = {
    val size = buf.readableBytes()
    if (size < HEADER_SIZE) {
      val err = "Packet size is less than minimum packet size. Discard it."
      logger.debug(err)
      return MsgHeaderDecodeResult(BadFrame(err))
    }

    val msgLength: Int = buf.readInt()
    if (msgLength < 0) {
      val err = s"Too large message length `$msgLength`."
      logger.debug(err)
      return MsgHeaderDecodeResult(BadFrame(err))
    }

    // verify msgLength
    if ((size + 4) != msgLength) {
      val err = s"Invalid msgLength `$msgLength`."
      logger.debug(err)
      return MsgHeaderDecodeResult(BadFrame(err))
    }

    val msgSn = buf.readInt()
    val msgId = buf.readUnsignedShort()


    val gnssCenterId = buf.readInt()

    val resultGnssCenterSettings =
      if (gnssCenterSettings == null) {
        gnssCenterRegistry.get(gnssCenterId)
      } else
        gnssCenterSettings

    if (resultGnssCenterSettings == null) {
      logger.debug(s"Not registered gnssCenterId `$gnssCenterId`.")

      return MsgHeaderDecodeResult(InvalidGnssCenterId(gnssCenterId))
    }

    buf.readBytes(tempBuf, 0, 3)
    val versionFlag = new VersionFlag(tempBuf, 0)

    val encryptFlag = buf.readByte()

    val encryptKey = buf.readInt()

    // rev.2011 has no time field
    //      val time = buf.readLong()


    val header = new JT809FrameHeader
    header.setMsgLength(msgLength)
    header.setMsgSn(msgSn)
    header.setMsgId(msgId)
    header.setGnssCenterId(gnssCenterId)
    header.setVersionFlag(versionFlag)
    header.setEncryptFlag(encryptFlag)
    header.setEncryptKey(encryptKey)
    //      header.setTime(time)

    //    logger.whenDebugEnabled {
    //      logger.debug(s"$header")
    //    }

    MsgHeaderDecodeResult(OK, header, resultGnssCenterSettings)
  }

  /**
   *
   * @param buf The buf, is un-escaped, crc-verified, only contains header and body, does not contain the start-tag, crc, and end-tag
   * @return Decode state
   */
  override def decode(gnssCenterSettings: GnssCenterSettings, buf: ByteBuf): MsgDecodeResult = {
    val dr = decodeHeader(gnssCenterSettings, buf)
    if (!dr.ok)
      return MsgDecodeResult(dr.state)

    val header = dr.header
    val msgBodyDecoder = msgBodyDecoderRegistry.get(header.getMsgId)
    val msg = if (msgBodyDecoder != null) {
      // the remains is body
      val body = if (header.getEncryptFlag != 0) {
        val settings =
          if (gnssCenterSettings == null) {
            val settings = gnssCenterRegistry.get(header.getGnssCenterId)
            if (settings == null)
              return MsgDecodeResult(InvalidGnssCenterId(header.getGnssCenterId))

            settings
          } else
            gnssCenterSettings

        val body = alloc.buffer()
        logger.whenDebugEnabled {
          logger.debug("Body Cipher Text: " + NettyUtils.bufToHex(buf))
        }
        decrypt(header.getEncryptKey, settings.cryptSettings, buf, buf.readableBytes(), body)
                  logger.whenDebugEnabled {
                    logger.debug("Body: " + NettyUtils.bufToHex(body))
                  }
        body
      } else {
        val r = buf.retainedSlice()
        //          r.readerIndex(buf.readerIndex())
        //          logger.whenDebugEnabled {
        //            logger.debug("Body: " + NettyUtils.bufToHex(r))
        //          }
        r
      }

      logger.whenDebugEnabled {
        logger.debug("Body: " + body.remainingToHexString)
      }


      try {
        msgBodyDecoder.decode(header, body)
      } catch {
        case t: Throwable =>
          return MsgDecodeResult(BadFrame("Decode failed"))
      }
    } else {
      new JT809Msg(header)
    }

    MsgDecodeResult(OK, msg, dr.gnssCenterSettings)
  }
}
