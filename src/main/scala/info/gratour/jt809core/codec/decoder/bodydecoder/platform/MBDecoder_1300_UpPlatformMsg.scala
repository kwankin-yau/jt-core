package info.gratour.jt809core.codec.decoder.bodydecoder.platform

import info.gratour.jt809core.codec.decoder.bodydecoder.JT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.platform.{JT809Msg_1301_UpPlatformMsgPostQueryAck, JT809Msg_1302_UpPlatformMsgInfoAck, JT809UpPlatformMsg}
import info.gratour.jt809core.protocol.{JT809FrameHeader, JT809Msg}
import io.netty.buffer.ByteBuf

object MBDecoder_1300_UpPlatformMsg extends JT809MsgBodyDecoder {
  override def msgId: Int = JT809UpPlatformMsg.MSG_ID

  override def decode(header: JT809FrameHeader, body: ByteBuf): JT809Msg = {
    val dataType = body.readUnsignedShort()
    body.skipBytes(4) // data-length

    dataType match {
      case JT809Msg_1301_UpPlatformMsgPostQueryAck.DATA_TYPE =>
        val m = new JT809Msg_1301_UpPlatformMsgPostQueryAck
        m.setHeader(header)
        m.setDataType(dataType)

        m.setObjectType(body.readByte())
        m.setObjectId(body.readStrMaxLen(20))
        m.setInfoId(body.readInt())
        m.setInfoContent(body.readIntLenPrefixedStr())

        m

      case JT809Msg_1302_UpPlatformMsgInfoAck.DATA_TYPE =>
        val m = new JT809Msg_1302_UpPlatformMsgInfoAck
        m.setHeader(header)
        m.setDataType(dataType)

        m.setInfoId(body.readInt())

        m
    }
  }
}
