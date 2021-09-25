package info.gratour.jt809core.codec.decoder.bodydecoder.warn

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.warn.{JT809DownWarnMsg, JT809Msg_9401_DownWarnMsgUrgeTodoReq, JT809Msg_9402_DownWarnMsgInformTips, JT809Msg_9403_DownWarnMsgExgInform, JT809Msg_9404_DownWarnMsgFileListReq_Sichuan, JT809Msg_9405_DownWarnMsgCheckReq_SiChuan, JT809Msg_9406_DownWarnMsgStaticsReq_SiChuan}
import io.netty.buffer.ByteBuf

object MBDecoder_9400_DownWarnMsg_SiChuan extends VehRelatedMsgBodyDecoder {
  override def msgId: Int = JT809DownWarnMsg.MSG_ID

  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9401_DownWarnMsgUrgeTodoReq =>
        m.setWarnSrc(buf.readByte())
        m.setWarnType(buf.readUnsignedShort())
        m.setWarnTime(buf.readLong())
        m.setSupervisionId(buf.readInt())
        m.setSupervisionEndTime(buf.readLong())
        m.setSupervisionLevel(buf.readByte())
        m.setSupervisor(buf.readStrMaxLen(16))
        m.setSupervisorTel(buf.readStrMaxLen(20))
        m.setSupervisorEmail(buf.readStrMaxLen(32))

      case m: JT809Msg_9402_DownWarnMsgInformTips =>
        m.setWarnSrc(buf.readByte())
        m.setWarnType(buf.readUnsignedShort())
        m.setWarnTime(buf.readLong())
        m.setWarnContent(buf.readIntLenPrefixedStr())

      case m: JT809Msg_9403_DownWarnMsgExgInform =>
        m.setWarnSrc(buf.readByte())
        m.setWarnType(buf.readUnsignedShort())
        m.setWarnTime(buf.readLong())
        m.setWarnContent(buf.readIntLenPrefixedStr())

      case m: JT809Msg_9404_DownWarnMsgFileListReq_Sichuan =>
        m.setInfoId(buf.readBytesLen(32))

      case m: JT809Msg_9405_DownWarnMsgCheckReq_SiChuan =>
        m.setWarnType(buf.readShort())
        m.setWarnTime(buf.readLong())

      case m: JT809Msg_9406_DownWarnMsgStaticsReq_SiChuan =>
        m.setStartTime(buf.readLong())
        m.setEndTime(buf.readLong())
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_9401_DownWarnMsgUrgeTodoReq],
    classOf[JT809Msg_9402_DownWarnMsgInformTips],
    classOf[JT809Msg_9403_DownWarnMsgExgInform],
    classOf[JT809Msg_9404_DownWarnMsgFileListReq_Sichuan],
    classOf[JT809Msg_9405_DownWarnMsgCheckReq_SiChuan],
    classOf[JT809Msg_9406_DownWarnMsgStaticsReq_SiChuan]
  )

}
