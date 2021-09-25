/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.encoder.bodyencoder.jt1078.download

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.download.{JT809Msg_1B01_UpDownloadMsgStartupAck, JT809Msg_1B02_UpDownloadMsgEndInform, JT809Msg_1B03_UpDownloadMsgControlAck, JT809UpDownloadMsg}
import io.netty.buffer.ByteBuf

object MBEncoder_1B00_UpDownloadMsg extends VehRelatedMsgBodyEncoder {
  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1B01_UpDownloadMsgStartupAck =>
        out.writeByte(m.getResult)
        out.writeShort(m.getSessionId)

      case m: JT809Msg_1B02_UpDownloadMsgEndInform =>
        out.writeByte(m.getResult)
        out.writeShort(m.getSessionId)
        out.writeFixedLenStr(m.getServerIp, 32)
        out.writeShort(m.getTcpPort)
        out.writeFixedLenStr(m.getUserName, 49)
        out.writeFixedLenStr(m.getPassword, 22)
        out.writeFixedLenStr(m.getFilePath, 200)

      case m: JT809Msg_1B03_UpDownloadMsgControlAck =>
        out.writeByte(m.getResult)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgId: Int = JT809UpDownloadMsg.MSG_ID
}
