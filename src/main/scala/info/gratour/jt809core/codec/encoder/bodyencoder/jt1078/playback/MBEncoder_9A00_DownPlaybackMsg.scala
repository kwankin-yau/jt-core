/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.encoder.bodyencoder.jt1078.playback

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.playback.{JT809DownPlaybackMsg, JT809Msg_9A01_DownPlaybackMsgStartup, JT809Msg_9A02_DownPlaybackMsgControl}
import io.netty.buffer.ByteBuf

object MBEncoder_9A00_DownPlaybackMsg extends VehRelatedMsgBodyEncoder {

  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9A01_DownPlaybackMsgStartup =>
        out.writeByte(m.getChannelId)
        out.writeByte(m.getAvItemType)
        out.writeByte(m.getStreamType)
        out.writeByte(m.getMemType)
        out.writeTimestamp(m.getPlaybackStartTime)
        out.writeTimestamp(m.getPlaybackEndTime)
        out.writeFixedLenStr(m.getAuthorizeCode, 64)
        out.writeGnssData(m.getGnssData)

      case m: JT809Msg_9A02_DownPlaybackMsgControl =>
        out.writeByte(m.getControlType)
        out.writeByte(m.getFastTime)
        out.writeTimestamp(m.getDateTime)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgId: Int = JT809DownPlaybackMsg.MSG_ID
}
