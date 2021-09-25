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
import info.gratour.jt809core.protocol.msg.jt1078.realvideo.{JT809Msg_1801_UpRealVideoMsgStartupAck, JT809Msg_1802_UpRealVideoMsgEndAck, JT809UpRealVideoMsg}
import io.netty.buffer.ByteBuf

object MBEncoder_1800_UpRealVideoMsg extends VehRelatedMsgBodyEncoder {
  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1801_UpRealVideoMsgStartupAck =>
        out.writeByte(m.getResult)
        out.writeFixedLenStr(m.getServerIp, 32)
        out.writeShort(m.getServerPort)

      case m: JT809Msg_1802_UpRealVideoMsgEndAck =>
        out.writeByte(m.getResult)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgId: Int = JT809UpRealVideoMsg.MSG_ID
}
