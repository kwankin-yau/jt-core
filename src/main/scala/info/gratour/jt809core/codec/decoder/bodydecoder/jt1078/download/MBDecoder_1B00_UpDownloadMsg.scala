/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.decoder.bodydecoder.jt1078.download

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.jt1078.download.{JT809Msg_1B01_UpDownloadMsgStartupAck, JT809Msg_1B02_UpDownloadMsgEndInform, JT809Msg_1B03_UpDownloadMsgControlAck, JT809UpDownloadMsg}
import io.netty.buffer.ByteBuf

object MBDecoder_1B00_UpDownloadMsg extends VehRelatedMsgBodyDecoder {
  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg.getDataType match {
      case JT809Msg_1B01_UpDownloadMsgStartupAck.DATA_TYPE =>
        val m = msg.asInstanceOf[JT809Msg_1B01_UpDownloadMsgStartupAck]
        m.setResult(buf.readByte())
        m.setSessionId(buf.readUnsignedShort())

      case JT809Msg_1B02_UpDownloadMsgEndInform.DATA_TYPE =>
        val m = msg.asInstanceOf[JT809Msg_1B02_UpDownloadMsgEndInform]
        m.setResult(buf.readByte())
        m.setSessionId(buf.readUnsignedShort())
        m.setServerIp(buf.readStrMaxLen(32))
        m.setTcpPort(buf.readUnsignedShort())
        m.setUserName(buf.readStrMaxLen(49))
        m.setPassword(buf.readStrMaxLen(22))
        m.setFilePath(buf.readStrMaxLen(200))

      case JT809Msg_1B03_UpDownloadMsgControlAck.DATA_TYPE =>
        val m = msg.asInstanceOf[JT809Msg_1B03_UpDownloadMsgControlAck]
        m.setResult(buf.readByte())

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_1B01_UpDownloadMsgStartupAck],
    classOf[JT809Msg_1B02_UpDownloadMsgEndInform],
    classOf[JT809Msg_1B03_UpDownloadMsgControlAck]
  )

  override def msgId: Int = JT809UpDownloadMsg.MSG_ID
}
