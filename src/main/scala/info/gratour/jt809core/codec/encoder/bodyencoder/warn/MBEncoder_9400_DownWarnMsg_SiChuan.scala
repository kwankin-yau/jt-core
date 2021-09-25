package info.gratour.jt809core.codec.encoder.bodyencoder.warn

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.warn.{JT809DownWarnMsg, JT809Msg_9401_DownWarnMsgUrgeTodoReq, JT809Msg_9402_DownWarnMsgInformTips, JT809Msg_9403_DownWarnMsgExgInform, JT809Msg_9404_DownWarnMsgFileListReq_Sichuan, JT809Msg_9405_DownWarnMsgCheckReq_SiChuan, JT809Msg_9406_DownWarnMsgStaticsReq_SiChuan}
import io.netty.buffer.ByteBuf

object MBEncoder_9400_DownWarnMsg_SiChuan extends VehRelatedMsgBodyEncoder {

  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9401_DownWarnMsgUrgeTodoReq =>
        out.writeByte(m.getWarnSrc)
        out.writeShort(m.getWarnType)
        out.writeLong(m.getWarnTime)
        out.writeInt(m.getSupervisionId)
        out.writeLong(m.getSupervisionEndTime)
        out.writeByte(m.getSupervisionLevel)
        out.writeFixedLenStr(m.getSupervisor, 16)
        out.writeFixedLenStr(m.getSupervisorTel, 20)
        out.writeFixedLenStr(m.getSupervisorEmail, 32)

      case m: JT809Msg_9402_DownWarnMsgInformTips =>
        out.writeByte(m.getWarnSrc)
        out.writeShort(m.getWarnType)
        out.writeLong(m.getWarnTime)
        out.writeIntLenPrefixedStr(m.getWarnContent)

      case m: JT809Msg_9403_DownWarnMsgExgInform =>
        out.writeByte(m.getWarnSrc)
        out.writeShort(m.getWarnType)
        out.writeLong(m.getWarnTime)
        out.writeIntLenPrefixedStr(m.getWarnContent)

      case m: JT809Msg_9404_DownWarnMsgFileListReq_Sichuan =>
        out.writeBytes(m.getInfoId)

      case m: JT809Msg_9405_DownWarnMsgCheckReq_SiChuan =>
        out.writeShort(m.getWarnType)
        out.writeLong(m.getWarnTime)

      case m: JT809Msg_9406_DownWarnMsgStaticsReq_SiChuan =>
        out.writeLong(m.getStartTime)
        out.writeLong(m.getEndTime)
    }
  }

  override def msgId: Int = JT809DownWarnMsg.MSG_ID

}
