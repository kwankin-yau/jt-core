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
import info.gratour.jt809core.protocol.msg.jt1078.playback.{JT809Msg_1A01_UpPlaybackMsgStartupAck, JT809Msg_1A02_UpPlaybackMsgControlAck, JT809UpPlaybackMsg}
import io.netty.buffer.ByteBuf

object MBEncoder_1A00_UpPlaybackMsg extends VehRelatedMsgBodyEncoder {

  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1A01_UpPlaybackMsgStartupAck =>
        out.writeFixedLenStr(m.getServerIp, 32)
        out.writeShort(m.getServerPort)
        out.writeByte(m.getResult)

      case m: JT809Msg_1A02_UpPlaybackMsgControlAck =>
        out.writeByte(m.getResult)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgId: Int = JT809UpPlaybackMsg.MSG_ID
}
