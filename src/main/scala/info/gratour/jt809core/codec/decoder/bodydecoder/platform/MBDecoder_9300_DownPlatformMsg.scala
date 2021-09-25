package info.gratour.jt809core.codec.decoder.bodydecoder.platform

import info.gratour.jt809core.codec.decoder.bodydecoder.JT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.platform.{JT809DownPlatformMsg, JT809Msg_1301_UpPlatformMsgPostQueryAck, JT809Msg_1302_UpPlatformMsgInfoAck, JT809Msg_9301_DownPlatformMsgPostQueryReq, JT809Msg_9302_DownPlatformMsgInfoReq}
import info.gratour.jt809core.protocol.{JT809FrameHeader, JT809Msg}
import io.netty.buffer.ByteBuf

object MBDecoder_9300_DownPlatformMsg extends JT809MsgBodyDecoder {
  override def msgId: Int = JT809DownPlatformMsg.MSG_ID

  override def decode(header: JT809FrameHeader, body: ByteBuf): JT809Msg = {
    val dataType = body.readUnsignedShort()
    body.skipBytes(4) // data-length
    dataType match {
      case JT809Msg_9301_DownPlatformMsgPostQueryReq.DATA_TYPE =>
        val m = new JT809Msg_9301_DownPlatformMsgPostQueryReq
        m.setHeader(header)
        m.setDataType(dataType)

        m.setObjectType(body.readByte())
        m.setObjectId(body.readStrMaxLen(20))
        m.setInfoId(body.readInt())
        m.setInfoContent(body.readIntLenPrefixedStr())

        m

      case JT809Msg_9302_DownPlatformMsgInfoReq.DATA_TYPE =>
        val m = new JT809Msg_9302_DownPlatformMsgInfoReq
        m.setHeader(header)
        m.setDataType(dataType)

        m.setObjectType(body.readByte())
        m.setObjectId(body.readStrMaxLen(20))
        m.setInfoId(body.readInt())
        m.setInfoContent(body.readIntLenPrefixedStr())

        m
    }
  }
}
