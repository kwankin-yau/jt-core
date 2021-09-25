/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.decoder.bodydecoder.jt1078.auth

import info.gratour.jt809core.codec.decoder.bodydecoder.JT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.jt1078.auth.JT809Msg_9702_DownAuthorizeMsgStartupReqAck
import info.gratour.jt809core.protocol.{JT809FrameHeader, JT809Msg, JT809MsgConsts}
import io.netty.buffer.ByteBuf

object MBDecoder_9700_DownAuthorizeMsg extends JT809MsgBodyDecoder {

  override def msgId: Int = JT809MsgConsts.AuthorizeMsgs.DOWN_AUTHORIZE_MSG_9700

  override def decode(header: JT809FrameHeader, body: ByteBuf): JT809Msg = {
    val plateNo = body.readStrMaxLen(21)
    val plateColor = body.readUnsignedByte()
    val dataType = body.readUnsignedShort()
    val len = body.readInt()

    dataType match {
      case JT809MsgConsts.AuthorizeMsgs.DOWN_AUTHORIZE_MSG_STARTUP_REQ_ACK_9702 =>
        val m = new JT809Msg_9702_DownAuthorizeMsgStartupReqAck
        m.setPlateNo(plateNo)
        m.setPlateColor(plateColor)
        m

      case _ =>
        throw notSupportedDataType(dataType)
    }

  }
}
