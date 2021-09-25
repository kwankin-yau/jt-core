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
import info.gratour.jt809core.protocol.msg.jt1078.realvideo.{JT809Msg_1801_UpRealVideoMsgStartupAck, JT809Msg_1802_UpRealVideoMsgEndAck, JT809UpRealVideoMsg}
import io.netty.buffer.ByteBuf

object MBDecoder_1800_UpRealVideoMsg extends VehRelatedMsgBodyDecoder {

  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1801_UpRealVideoMsgStartupAck =>
        m.setResult(buf.readByte())
        m.setServerIp(buf.readStrMaxLen(32))
        m.setServerPort(buf.readUnsignedShort())

      case m: JT809Msg_1802_UpRealVideoMsgEndAck =>
        m.setResult(buf.readByte())

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_1801_UpRealVideoMsgStartupAck],
    classOf[JT809Msg_1802_UpRealVideoMsgEndAck]
  )

  override def msgId: Int = JT809UpRealVideoMsg.MSG_ID
}
