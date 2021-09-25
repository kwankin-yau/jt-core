/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.encoder.bodyencoder.jt1078.auth

import info.gratour.jt809core.codec.encoder.bodyencoder.MsgBodyEncoder
import info.gratour.jt809core.protocol.msg.jt1078.auth.{JT809Msg_1701_UpAuthorizeMsgStartup, JT809Msg_1702_UpAuthorizeMsgStartupReq, JT809UpAuthorizeMsg}
import info.gratour.jt809core.protocol.{JT809Msg, JT809MsgConsts}
import io.netty.buffer.ByteBuf

object MBEncoder_1700_UpAuthorizeMsg extends MsgBodyEncoder {

  override def msgId: Int = JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_1700

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    val msg = m.asInstanceOf[JT809UpAuthorizeMsg]

    msg.getDataType match {
      case JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_STARTUP_1701 =>
        val v = msg.asInstanceOf[JT809Msg_1701_UpAuthorizeMsgStartup]
        out.writeShort(msg.getDataType)
        out.writeFixedLenStr(v.getPlatformId, 11)
        out.writeFixedLenStr(v.getAuthorizeCode1, 64)
        out.writeFixedLenStr(v.getAuthorizeCode2, 64)

      case JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_REQ_1702 =>
        val v = msg.asInstanceOf[JT809Msg_1702_UpAuthorizeMsgStartupReq]
        out.writeFixedLenStr(v.getPlateNo, 21)
        out.writeByte(v.getPlateColor)
        out.writeShort(v.getDataType)
        out.writeInt(0)

      case _ =>
        throw notSupportedDataType(msg.getDataType)
    }
  }
}
