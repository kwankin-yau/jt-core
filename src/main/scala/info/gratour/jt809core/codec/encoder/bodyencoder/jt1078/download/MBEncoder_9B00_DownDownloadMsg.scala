/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.encoder.bodyencoder.jt1078.download

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.download.{JT809DownDownloadMsg, JT809Msg_9B01_DownDownloadMsgStartup, JT809Msg_9B02_DownDownloadMsgEndInformAck, JT809Msg_9B03_DownDownloadMsgControl}
import io.netty.buffer.ByteBuf

object MBEncoder_9B00_DownDownloadMsg extends VehRelatedMsgBodyEncoder {
  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9B01_DownDownloadMsgStartup =>
        out.writeByte(m.getChannelId)
        out.writeLong(m.getStartTime)
        out.writeLong(m.getEndTime)
        out.writeInt(m.getAlarmType808)
        out.writeInt(m.getAlarmType1078)
        out.writeByte(m.getAvItemType)
        out.writeByte(m.getStreamType)
        out.writeByte(m.getMemType)
        out.writeInt(m.getFileSize.toInt)
        out.writeFixedLenStr(m.getAuthorizeCode, 64)
        out.writeGnssData(m.getGnssData)

      case m: JT809Msg_9B02_DownDownloadMsgEndInformAck =>
        out.writeByte(m.getResult)
        out.writeShort(m.getSessionId)

      case m: JT809Msg_9B03_DownDownloadMsgControl =>
        out.writeShort(m.getSessionId)
        out.writeByte(m.getTyp)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgId: Int = JT809DownDownloadMsg.MSG_ID
}
