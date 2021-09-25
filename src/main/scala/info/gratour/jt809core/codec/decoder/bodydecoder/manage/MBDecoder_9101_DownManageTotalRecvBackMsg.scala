/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.decoder.bodydecoder.manage

import info.gratour.jt809core.codec.decoder.bodydecoder.JT809MsgBodyDecoder
import info.gratour.jt809core.protocol.msg.mgnt.JT809Msg_9101_DownManageTotalRecvBackMsg
import info.gratour.jt809core.protocol.{JT809FrameHeader, JT809Msg, JT809MsgConsts}
import io.netty.buffer.ByteBuf

object MBDecoder_9101_DownManageTotalRecvBackMsg extends JT809MsgBodyDecoder {
  override def msgId: Int = JT809MsgConsts.ManageMsgs.DOWN_MANAGE_TOTAL_RECV_BACK_MSG_9101

  override def decode(header: JT809FrameHeader, body: ByteBuf): JT809Msg = {
    val m = new JT809Msg_9101_DownManageTotalRecvBackMsg
    m.setHeader(header)

    m.setDynamicInfoTotal(body.readInt())
    m.setStartTime(body.readLong())
    m.setEndTime(body.readLong())

    m
  }
}
