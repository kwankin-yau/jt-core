package info.gratour.jt808core.codec.decoder.impl

import info.gratour.jt808core.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808core.protocol.msg.JT808Msg_0001_TerminalGeneralAck
import info.gratour.jt808core.protocol.{JT808FrameHeader, JT808Msg}
import io.netty.buffer.ByteBuf

object MBDecoder808_0001_DeviceGeneralAck extends JT808MsgBodyDecoder[JT808Msg_0001_TerminalGeneralAck] {

  override def decodeMsgBody(m: JT808Msg_0001_TerminalGeneralAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    m.setAckMsgId(body.readUnsignedShort())
    m.setResult(body.readByte())
  }
}


