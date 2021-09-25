package info.gratour.jt809core.codec.encoder.bodyencoder.warn

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.warn.{JT809Msg_1401_UpWarnMsgUrgeTodoAck, JT809Msg_1402_UpWarnMsgAdptInfo, JT809Msg_1402_UpWarnMsgAdptInfo_SiChuan, JT809Msg_1403_UpWarnMsgOperationInfo_SiChuan, JT809Msg_1404_UpWarnMsgFileListAck_SiChuan, JT809Msg_1405_UpWarnMsgCheckAck_SiChuan, JT809Msg_1406_UpWarnMsgStaticsAck_SiChuan, JT809UpWarnMsg}
import io.netty.buffer.ByteBuf

object MBEncoder_1400_UpWarnMsg_SiChuan extends VehRelatedMsgBodyEncoder {

  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1401_UpWarnMsgUrgeTodoAck =>
        out.writeInt(m.getSupervisionId)
        out.writeByte(m.getResult)

      case m: JT809Msg_1402_UpWarnMsgAdptInfo_SiChuan =>
        out.writeByte(m.getWarnSrc)
        out.writeShort(m.getWarnType)
        out.writeLong(m.getWarnTime)
        out.writeFixedLenBytes(m.getInfoId, 32)
        out.writeByteLenPrefixedStr(m.getDriver)
        out.writeByteLenPrefixedStr(m.getDriverNo)
        out.writeByte(m.getLevel)
        out.writeAxis(m.getLon)
        out.writeAxis(m.getLat)
        out.writeShort(m.getAlt)
        out.writeShort(m.getVec1)
        out.writeShort(m.getVec2)
        out.writeByte(m.getStatus)
        out.writeShort(m.getDirection)
        out.writeShortLenPrefixedStr(m.getInfoContent)

      case m: JT809Msg_1403_UpWarnMsgOperationInfo_SiChuan =>
        out.writeBytes(m.getInfoId)
        out.writeByte(m.getResult)
        out.writeByte(m.getMethod)
        out.writeByteLenPrefixedStr(m.getOperator)
        out.writeByteLenPrefixedStr(m.getCompany)

      case m: JT809Msg_1404_UpWarnMsgFileListAck_SiChuan =>
        out.writeBytes(m.getInfoId)
        out.writeByteLenPrefixedStr(m.getServerAddr)
        out.writeShort(m.getPort)
        out.writeByteLenPrefixedStr(m.getUserName)
        out.writeByteLenPrefixedStr(m.getPassword)
        out.writeByte(m.fileCount())
        if (m.fileCount() > 0)
          m.getFileList.forEach(file => {
            out.writeByteLenPrefixedStr(file.getFileName)
            out.writeByte(file.getFileType)
            out.writeInt(file.getFileSize)
            out.writeByteLenPrefixedStr(file.getFileUrl)
          })

      case m: JT809Msg_1405_UpWarnMsgCheckAck_SiChuan =>
        out.writeByte(m.getWarnSrc)
        out.writeShort(m.getWarnType)
        out.writeLong(m.getWarnTime)
        out.writeFixedLenStr(m.getInfoId, 32)
        out.writeByteLenPrefixedStr(m.getDriver)
        out.writeByteLenPrefixedStr(m.getDriverNo)
        out.writeByte(m.getLevel)
        out.writeAxis(m.getLng)
        out.writeAxis(m.getLat)
        out.writeShort(m.getAlt)
        out.writeShort(m.getVec1)
        out.writeShort(m.getVec2)
        out.writeByte(m.getStatus)
        out.writeShort(m.getDirection)
        out.writeShortLenPrefixedStr(m.getInfoContent)

      case m: JT809Msg_1406_UpWarnMsgStaticsAck_SiChuan =>
        if (m.getStaticsItems != null) {
          m.getStaticsItems.forEach(item => {
            out.writeShort(item.getWarnType)
            out.writeInt(item.getStatics)
          })
        }
    }
  }

  override def msgId: Int = JT809UpWarnMsg.MSG_ID

}
