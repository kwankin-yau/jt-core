package info.gratour.jt809core.codec.decoder.bodydecoder.warn

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.warn.{JT809Msg_1401_UpWarnMsgUrgeTodoAck, JT809Msg_1402_UpWarnMsgAdptInfo, JT809UpWarnMsg}
import io.netty.buffer.ByteBuf

object MBDecoder_1400_UpWarnMsg extends VehRelatedMsgBodyDecoder {

  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1401_UpWarnMsgUrgeTodoAck =>
        m.setSupervisionId(buf.readInt())
        m.setResult(buf.readByte())

      case m: JT809Msg_1402_UpWarnMsgAdptInfo =>
        m.setWarnSrc(buf.readByte())
        m.setWarnType(buf.readUnsignedShort())
        m.setWarnTime(buf.readLong())
        m.setInfoId(buf.readInt())
        m.setInfoContent(buf.readIntLenPrefixedStr())
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_1401_UpWarnMsgUrgeTodoAck],
    classOf[JT809Msg_1402_UpWarnMsgAdptInfo]
  )

  override def msgId: Int = JT809UpWarnMsg.MSG_ID
}
