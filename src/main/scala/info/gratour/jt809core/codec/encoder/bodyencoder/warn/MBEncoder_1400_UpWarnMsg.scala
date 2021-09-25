package info.gratour.jt809core.codec.encoder.bodyencoder.warn

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.warn.{JT809Msg_1401_UpWarnMsgUrgeTodoAck, JT809Msg_1402_UpWarnMsgAdptInfo, JT809UpWarnMsg}
import io.netty.buffer.ByteBuf

object MBEncoder_1400_UpWarnMsg extends VehRelatedMsgBodyEncoder{
  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1401_UpWarnMsgUrgeTodoAck =>
        out.writeInt(m.getSupervisionId)
        out.writeByte(m.getResult)

      case m: JT809Msg_1402_UpWarnMsgAdptInfo =>
        out.writeByte(m.getWarnSrc)
        out.writeShort(m.getWarnType)
        out.writeLong(m.getWarnTime)
        out.writeInt(m.getInfoId)
        out.writeIntLenPrefixedStr(m.getInfoContent)
    }
  }

  override def msgId: Int = JT809UpWarnMsg.MSG_ID
}
