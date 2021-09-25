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
import info.gratour.jt809core.protocol.msg.jt1078.filelist.{JT809Msg_1901_UpFileListMsg, JT809Msg_1902_UpFileListReqAck, JT809UpFileListMsg, JT809_1078AvResItem}
import io.netty.buffer.ByteBuf

object MBEncoder_1900_UpFileListMsg extends VehRelatedMsgBodyEncoder {
  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {

    def writeItem(item: JT809_1078AvResItem): Unit = {
      out.writeByte(item.getChannelId)
      out.writeTimestamp(item.getStartTime)
      out.writeTimestamp(item.getEndTime)
      out.writeInt(item.getAlarmType808)
      out.writeInt(item.getAlarmType1078)
      out.writeByte(item.getAvItemType)
      out.writeByte(item.getStreamType)
      out.writeByte(item.getMemType)
      out.writeInt(item.getFileSize.toInt)
    }

    msg match {
      case m: JT809Msg_1901_UpFileListMsg =>
        val list = checkNotNull(m.getItemList, "itemList")
        val cnt = list.size()
        out.writeInt(cnt)
        for (i <- 0 until cnt) {
          val item = list.get(i)
          writeItem(item)
        }

      case m: JT809Msg_1902_UpFileListReqAck =>
        out.writeByte(m.getResult)
        if (m.getItemList != null) {
          val cnt = m.getItemList.size()
          out.writeInt(cnt)

          for (i <- 0 until cnt) {
            val item = m.getItemList.get(i)
            writeItem(item)
          }
        } else
          out.writeInt(0)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgId: Int = JT809UpFileListMsg.MSG_ID
}
