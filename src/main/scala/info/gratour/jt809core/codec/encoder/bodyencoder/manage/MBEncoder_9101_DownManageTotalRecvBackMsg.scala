/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt809core.codec.encoder.bodyencoder.manage

import info.gratour.common.error.ErrorWithCode
import info.gratour.jt809core.codec.encoder.bodyencoder.MsgBodyEncoder
import info.gratour.jt809core.protocol.msg.mgnt.JT809Msg_9101_DownManageTotalRecvBackMsg
import info.gratour.jt809core.protocol.{JT809Msg, JT809MsgConsts}
import io.netty.buffer.ByteBuf

object MBEncoder_9101_DownManageTotalRecvBackMsg extends MsgBodyEncoder {
  override def msgId: Int = JT809MsgConsts.ManageMsgs.DOWN_MANAGE_TOTAL_RECV_BACK_MSG_9101

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    m match {
      case m: JT809Msg_9101_DownManageTotalRecvBackMsg =>
        out.writeInt(m.getDynamicInfoTotal.toInt)
        out.writeLong(m.getStartTime)
        out.writeLong(m.getEndTime)

      case _ =>
        throw ErrorWithCode.internalError("Not implemented.")
    }
  }
}
