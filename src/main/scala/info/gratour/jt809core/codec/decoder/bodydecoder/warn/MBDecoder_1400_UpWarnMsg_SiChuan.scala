package info.gratour.jt809core.codec.decoder.bodydecoder.warn

import java.util

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.warn.{JT809Msg_1401_UpWarnMsgUrgeTodoAck, JT809Msg_1402_UpWarnMsgAdptInfo_SiChuan, JT809Msg_1403_UpWarnMsgOperationInfo_SiChuan, JT809Msg_1404_UpWarnMsgFileListAck_SiChuan, JT809Msg_1405_UpWarnMsgCheckAck_SiChuan, JT809Msg_1406_UpWarnMsgStaticsAck_SiChuan, JT809UpWarnMsg, UpWarnMsgFileInfo_SiChuan, UpWarnMsgStaticsItem_SiChuan}
import io.netty.buffer.ByteBuf

object MBDecoder_1400_UpWarnMsg_SiChuan extends VehRelatedMsgBodyDecoder {


  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1401_UpWarnMsgUrgeTodoAck =>
        m.setSupervisionId(buf.readInt())
        m.setResult(buf.readByte())

      case m: JT809Msg_1402_UpWarnMsgAdptInfo_SiChuan =>
        m.setWarnSrc(buf.readByte())
        m.setWarnType(buf.readUnsignedShort())
        m.setWarnTime(buf.readLong())
        val infoId = new Array[Byte](32)
        buf.readBytes(infoId)
        m.setInfoId(infoId)
        m.setDriver(buf.readByteLenPrefixedStr())
        m.setDriverNo(buf.readByteLenPrefixedStr())
        m.setLevel(buf.readByte())
        m.setLon(intAxisToDouble(buf.readInt()))
        m.setLat(intAxisToDouble(buf.readInt()))
        m.setAlt(buf.readShort())
        m.setVec1(buf.readUnsignedShort())
        m.setVec2(buf.readUnsignedShort())
        m.setStatus(buf.readByte())
        m.setDirection(buf.readShort())
        m.setInfoContent(buf.readShortLenPrefixedStr()) // short

      case m: JT809Msg_1403_UpWarnMsgOperationInfo_SiChuan =>
        m.setInfoId(buf.readBytesLen(32))
        m.setResult(buf.readByte())
        m.setMethod(buf.readByte())
        m.setOperator(buf.readByteLenPrefixedStr())
        m.setCompany(buf.readByteLenPrefixedStr())

      case m: JT809Msg_1404_UpWarnMsgFileListAck_SiChuan =>
        m.setInfoId(buf.readBytesLen(32))
        m.setServerAddr(buf.readByteLenPrefixedStr())
        m.setPort(buf.readUnsignedShort())
        m.setUserName(buf.readByteLenPrefixedStr())
        m.setPassword(buf.readByteLenPrefixedStr())
        val count = buf.readUnsignedByte()
        val list = new util.ArrayList[UpWarnMsgFileInfo_SiChuan]()
        for (_ <- 1 to count) {
          val fileItem = new UpWarnMsgFileInfo_SiChuan
          fileItem.setFileName(buf.readByteLenPrefixedStr())
          fileItem.setFileType(buf.readByte())
          fileItem.setFileSize(buf.readInt())
          fileItem.setFileUrl(buf.readByteLenPrefixedStr())
          list.add(fileItem)
        }
        m.setFileList(list)

      case m: JT809Msg_1405_UpWarnMsgCheckAck_SiChuan =>
        m.setWarnSrc(buf.readByte())
        m.setWarnType(buf.readShort())
        m.setWarnTime(buf.readLong())
        m.setInfoId(buf.readStrMaxLen(32))
        m.setDriver(buf.readByteLenPrefixedStr())
        m.setDriverNo(buf.readByteLenPrefixedStr())
        m.setLevel(buf.readByte())
        m.setLng(buf.readAxis())
        m.setLat(buf.readAxis())
        m.setAlt(buf.readShort())
        m.setVec1(buf.readShort())
        m.setVec2(buf.readShort())
        m.setStatus(buf.readByte())
        m.setDirection(buf.readShort())
        m.setInfoContent(buf.readShortLenPrefixedStr())

      case m: JT809Msg_1406_UpWarnMsgStaticsAck_SiChuan =>
        val list = new util.ArrayList[UpWarnMsgStaticsItem_SiChuan]()
        while (buf.readableBytes() >= 6) {
          val item = new UpWarnMsgStaticsItem_SiChuan
          item.setWarnType(buf.readShort())
          item.setStatics(buf.readInt())

          list.add(item)
        }
        m.setStaticsItems(list)
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_1401_UpWarnMsgUrgeTodoAck],
    classOf[JT809Msg_1402_UpWarnMsgAdptInfo_SiChuan],
    classOf[JT809Msg_1403_UpWarnMsgOperationInfo_SiChuan],
    classOf[JT809Msg_1404_UpWarnMsgFileListAck_SiChuan],
    classOf[JT809Msg_1405_UpWarnMsgCheckAck_SiChuan],
    classOf[JT809Msg_1406_UpWarnMsgStaticsAck_SiChuan]
  )

  override def msgId: Int = JT809UpWarnMsg.MSG_ID

}
