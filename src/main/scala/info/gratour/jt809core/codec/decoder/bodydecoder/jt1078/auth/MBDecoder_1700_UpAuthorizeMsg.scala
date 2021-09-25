/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.decoder.bodydecoder.jt1078.auth

import info.gratour.jt809core.codec.decoder.bodydecoder.JT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.jt1078.auth.{JT809Msg_1701_UpAuthorizeMsgStartup, JT809Msg_1702_UpAuthorizeMsgStartupReq}
import info.gratour.jt809core.protocol.{JT809FrameHeader, JT809Msg, JT809MsgConsts}
import io.netty.buffer.ByteBuf

object MBDecoder_1700_UpAuthorizeMsg extends JT809MsgBodyDecoder{

  override def msgId: Int = JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_1700

  override def decode(header: JT809FrameHeader, body: ByteBuf): JT809Msg = {
    if (body.readableBytes() == 2 + 11 + 64 + 64) {
      val dataType = body.readUnsignedShort();
      dataType match {
        case JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_STARTUP_1701 =>
          val m = new JT809Msg_1701_UpAuthorizeMsgStartup
          m.setPlatformId(body.readStrMaxLen(11))
          m.setAuthorizeCode1(body.readStrMaxLen(64))
          m.setAuthorizeCode2(body.readStrMaxLen(64))
          m

        case _ =>
          throw notSupportedDataType(dataType)
      }
    } else {
      val plateNo = body.readStrMaxLen(21)
      val plateColor = body.readByte()
      val dataType = body.readUnsignedByte()
      val len = body.readInt()

      dataType match {
        case JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_REQ_1702 =>
          val m = new JT809Msg_1702_UpAuthorizeMsgStartupReq
          m.setPlateNo(plateNo)
          m.setPlateColor(plateColor)
          m

        case _ =>
          throw notSupportedDataType(dataType)
      }
    }
  }
}
