/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.decoder.bodydecoder.jt1078.download

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.download.{JT809DownDownloadMsg, JT809Msg_9B01_DownDownloadMsgStartup, JT809Msg_9B02_DownDownloadMsgEndInformAck, JT809Msg_9B03_DownDownloadMsgControl}
import io.netty.buffer.ByteBuf

object MBDecoder_9B00_DownDownloadMsg extends VehRelatedMsgBodyDecoder {
  //  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
  //    msg.getDataType match {
  //      case JT809Msg_9B01_DownDownloadMsgStartup.DATA_TYPE =>
  //        val m = msg.asInstanceOf[JT809Msg_9B01_DownDownloadMsgStartup]
  //        out.writeByte(m.getChannelId)
  //        out.writeLong(m.getStartTime)
  //        out.writeLong(m.getEndTime)
  //        out.writeInt(m.getAlarmType808)
  //        out.writeInt(m.getAlarmType1078)
  //        out.writeByte(m.getAvItemType)
  //        out.writeByte(m.getStreamType)
  //        out.writeByte(m.getMemType)
  //        out.writeInt(m.getFileSize.toInt)
  //        out.writeFixedLenStr(m.getAuthorizeCode, 64)
  //        out.writeGnssData(m.getGnssData)
  //
  //      case JT809Msg_9B02_DownDownloadMsgEndInformAck.DATA_TYPE =>
  //        val m = msg.asInstanceOf[JT809Msg_9B02_DownDownloadMsgEndInformAck]
  //        out.writeByte(m.getResult)
  //        out.writeShort(m.getSessionId)
  //
  //      case JT809Msg_9B03_DownDownloadMsgControl.DATA_TYPE =>
  //        val m = msg.asInstanceOf[JT809Msg_9B03_DownDownloadMsgControl]
  //        out.writeShort(m.getSessionId)
  //        out.writeByte(m.getTyp)
  //
  //      case _ =>
  //        throw NOT_SUPPORTED
  //    }
  //  }
  //
  //  override def msgId: Int = JT809DownDownloadMsg.MSG_ID
  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9B01_DownDownloadMsgStartup =>
        m.setChannelId(buf.readByte())
        m.setStartTime(buf.readTimestamp)
        m.setEndTime(buf.readTimestamp)
        m.setAlarmType808(buf.readInt())
        m.setAlarmType1078(buf.readInt())
        m.setAvItemType(buf.readByte())
        m.setStreamType(buf.readByte())
        m.setMemType(buf.readByte())
        m.setFileSize(buf.readUnsignedInt())
        m.setAuthorizeCode(buf.readStrMaxLen(64))
        m.setGnssData(buf.readGnssData)

      case m: JT809Msg_9B02_DownDownloadMsgEndInformAck =>
        m.setResult(buf.readByte())
        m.setSessionId(buf.readUnsignedShort())

      case m: JT809Msg_9B03_DownDownloadMsgControl =>
        m.setSessionId(buf.readUnsignedShort())
        m.setTyp(buf.readByte())

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_9B01_DownDownloadMsgStartup],
    classOf[JT809Msg_9B02_DownDownloadMsgEndInformAck],
    classOf[JT809Msg_9B03_DownDownloadMsgControl]
  )

  override def msgId: Int = JT809DownDownloadMsg.MSG_ID
}
