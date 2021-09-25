/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.decoder.bodydecoder.jt1078.realvideo

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.realvideo.{JT809DownRealVideoMsg, JT809Msg_9801_DownRealVideoMsgStartup, JT809Msg_9802_DownRealVideoMsgEnd}
import io.netty.buffer.ByteBuf

object MBDecoder_9800_DownRealVideoMsg extends VehRelatedMsgBodyDecoder {
  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9801_DownRealVideoMsgStartup =>
        m.setChannelId(buf.readByte())
        m.setAvItemType(buf.readByte())
        m.setAuthorizeCode(buf.readStrMaxLen(64))
        m.setGnssData(buf.readGnssData)

      case m: JT809Msg_9802_DownRealVideoMsgEnd =>
        m.setChannelId(buf.readByte())
        m.setAvItemType(buf.readByte())

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_9801_DownRealVideoMsgStartup],
    classOf[JT809Msg_9802_DownRealVideoMsgEnd]
  )

  override def msgId: Int = JT809DownRealVideoMsg.MSG_ID
}
