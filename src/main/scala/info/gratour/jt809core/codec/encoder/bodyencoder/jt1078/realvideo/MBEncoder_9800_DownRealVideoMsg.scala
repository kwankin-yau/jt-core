/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.encoder.bodyencoder.jt1078.realvideo

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.realvideo.{JT809DownRealVideoMsg, JT809Msg_9801_DownRealVideoMsgStartup, JT809Msg_9802_DownRealVideoMsgEnd}
import io.netty.buffer.ByteBuf

object MBEncoder_9800_DownRealVideoMsg extends VehRelatedMsgBodyEncoder {
  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9801_DownRealVideoMsgStartup =>
        out.writeByte(m.getChannelId)
        out.writeByte(m.getAvItemType)
        out.writeFixedLenStr(m.getAuthorizeCode, 64)
        out.writeGnssData(m.getGnssData)

      case m: JT809Msg_9802_DownRealVideoMsgEnd =>
        out.writeByte(m.getChannelId)
        out.writeByte(m.getAvItemType)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }

  }

  override def msgId: Int = JT809DownRealVideoMsg.MSG_ID
}
