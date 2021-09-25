/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.decoder.bodydecoder.jt1078.filelist

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.filelist.{JT809Msg_1901_UpFileListMsg, JT809Msg_1902_UpFileListReqAck, JT809UpFileListMsg, JT809_1078AvResItem}
import io.netty.buffer.ByteBuf

object MBDecoder_1900_UpFileListMsg extends VehRelatedMsgBodyDecoder {
  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {

    def decodeItem: JT809_1078AvResItem = {
      val item = new JT809_1078AvResItem
      item.setChannelId(buf.readByte())
      item.setStartTime(buf.readTimestamp)
      item.setEndTime(buf.readTimestamp)
      item.setAlarmType808(buf.readInt())
      item.setAlarmType1078(buf.readInt())
      item.setAvItemType(buf.readByte())
      item.setStreamType(buf.readByte())
      item.setMemType(buf.readByte())
      item.setFileSize(buf.readInt())

      item
    }

    msg match {
      case m: JT809Msg_1901_UpFileListMsg =>
        val cnt = buf.readInt()
        for (_ <- 1 to cnt) {
          m.addItem(decodeItem)
        }

      case m: JT809Msg_1902_UpFileListReqAck =>
        m.setResult(buf.readByte())
        if (buf.readableBytes() > 4) {
          val cnt = buf.readInt()
          for (_ <- 1 to cnt) {
            m.addItem(decodeItem)
          }
        }

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_1901_UpFileListMsg],
    classOf[JT809Msg_1902_UpFileListReqAck]
  )

  override def msgId: Int = JT809UpFileListMsg.MSG_ID
}
