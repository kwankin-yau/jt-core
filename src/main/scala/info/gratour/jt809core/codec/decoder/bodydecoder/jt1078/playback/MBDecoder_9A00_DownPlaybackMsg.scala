/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.decoder.bodydecoder.jt1078.playback

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.playback.{JT809DownPlaybackMsg, JT809Msg_9A01_DownPlaybackMsgStartup, JT809Msg_9A02_DownPlaybackMsgControl}
import io.netty.buffer.ByteBuf

object MBDecoder_9A00_DownPlaybackMsg extends VehRelatedMsgBodyDecoder {
  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9A01_DownPlaybackMsgStartup =>
        m.setChannelId(buf.readByte())
        m.setAvItemType(buf.readByte())
        m.setStreamType(buf.readByte())
        m.setMemType(buf.readByte())
        m.setPlaybackStartTime(buf.readTimestamp)
        m.setPlaybackEndTime(buf.readTimestamp)
        m.setAuthorizeCode(buf.readStrMaxLen(64))
        m.setGnssData(buf.readGnssData)

      case m: JT809Msg_9A02_DownPlaybackMsgControl =>
        m.setControlType(buf.readByte())
        m.setFastTime(buf.readByte())
        if (buf.readableBytes() > 8)
          m.setDateTime(buf.readTimestamp)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_9A01_DownPlaybackMsgStartup],
    classOf[JT809Msg_9A02_DownPlaybackMsgControl]
  )

  override def msgId: Int = JT809DownPlaybackMsg.MSG_ID
}
