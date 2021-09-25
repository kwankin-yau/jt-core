/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.encoder.bodyencoder.jt1078.filelist

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.filelist.{JT809DownFileListMsg, JT809Msg_9901_DownFileListMsgAck, JT809Msg_9902_DownFileListReq}
import io.netty.buffer.ByteBuf

object MBEncoder_9900_DownFileListMsg extends VehRelatedMsgBodyEncoder {
  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9901_DownFileListMsgAck =>
        out.writeByte(m.getResult)
        out.writeByte(m.getItemNumber)

      case m: JT809Msg_9902_DownFileListReq =>
        checkNotNull(m.getGnssData, "gnssData")
        out.writeByte(m.getChannelId)
        out.writeTimestamp(m.getStartTime)
        out.writeTimestamp(m.getEndTime)
        out.writeInt(m.getAlarmType808)
        out.writeInt(m.getAlarmType1078)
        out.writeByte(m.getAvItemType)
        out.writeByte(m.getStreamType)
        out.writeByte(m.getMemType)
        out.writeFixedLenStr(m.getAuthorizeCode, 64)
        out.writeGnssData(m.getGnssData)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgId: Int = JT809DownFileListMsg.MSG_ID
}
