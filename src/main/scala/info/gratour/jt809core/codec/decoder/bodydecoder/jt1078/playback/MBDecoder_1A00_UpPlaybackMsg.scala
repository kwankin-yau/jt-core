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
import info.gratour.jt809core.protocol.msg.jt1078.playback.{JT809Msg_1A01_UpPlaybackMsgStartupAck, JT809Msg_1A02_UpPlaybackMsgControlAck, JT809UpPlaybackMsg}
import io.netty.buffer.ByteBuf

object MBDecoder_1A00_UpPlaybackMsg extends VehRelatedMsgBodyDecoder {
  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1A01_UpPlaybackMsgStartupAck =>
        m.setServerIp(buf.readStrMaxLen(32))
        m.setServerPort(buf.readUnsignedShort())
        m.setResult(buf.readByte())

      case m: JT809Msg_1A02_UpPlaybackMsgControlAck =>
        m.setResult(buf.readByte())

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_1A01_UpPlaybackMsgStartupAck],
    classOf[JT809Msg_1A02_UpPlaybackMsgControlAck]
  )

  override def msgId: Int = JT809UpPlaybackMsg.MSG_ID
}
