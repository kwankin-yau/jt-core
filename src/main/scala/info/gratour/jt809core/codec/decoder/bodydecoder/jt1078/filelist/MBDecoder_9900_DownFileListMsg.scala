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
import info.gratour.jt809core.protocol.msg.jt1078.filelist.{JT809DownFileListMsg, JT809Msg_9901_DownFileListMsgAck, JT809Msg_9902_DownFileListReq}
import io.netty.buffer.ByteBuf

object MBDecoder_9900_DownFileListMsg extends VehRelatedMsgBodyDecoder {
  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9901_DownFileListMsgAck =>
        m.setResult(buf.readByte())
        m.setItemNumber(buf.readUnsignedByte())

      case m: JT809Msg_9902_DownFileListReq =>
        m.setChannelId(buf.readByte())
        m.setStartTime(buf.readTimestamp)
        m.setEndTime(buf.readTimestamp)
        m.setAlarmType808(buf.readInt())
        m.setAlarmType1078(buf.readInt())
        m.setAvItemType(buf.readByte())
        m.setStreamType(buf.readByte())
        m.setMemType(buf.readByte())
        m.setAuthorizeCode(buf.readStrMaxLen(64))
        m.setGnssData(buf.readGnssData)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_9901_DownFileListMsgAck],
    classOf[JT809Msg_9902_DownFileListReq]
  )

  override def msgId: Int = JT809DownFileListMsg.MSG_ID
}
