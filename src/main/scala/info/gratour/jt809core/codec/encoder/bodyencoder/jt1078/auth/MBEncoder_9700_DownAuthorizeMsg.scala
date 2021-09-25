/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.encoder.bodyencoder.jt1078.auth

import info.gratour.jt809core.codec.encoder.bodyencoder.MsgBodyEncoder
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.protocol.msg.jt1078.auth.{JT809DownAuthorizeMsg, JT809Msg_9702_DownAuthorizeMsgStartupReqAck}
import io.netty.buffer.ByteBuf

@Deprecated
object MBEncoder_9700_DownAuthorizeMsg extends MsgBodyEncoder {

  override def msgId: Int = JT809DownAuthorizeMsg.MSG_ID

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    m match {
      case msg: JT809Msg_9702_DownAuthorizeMsgStartupReqAck =>
        out.writeFixedLenStr(msg.getPlateNo, 21)
        out.writeByte(msg.getPlateColor)
        out.writeShort(msg.getDataType)
        out.writeInt(0)

      case _ =>
        throw notSupportedMsgType(m.getClass)
    }
  }
}
