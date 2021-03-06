/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.encoder.impl

import info.gratour.jt808core.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808core.protocol.msg.JT1078Msg_9105_LiveAVStatus
import io.netty.buffer.ByteBuf

object MBEncoder1078_9105_LiveAVStatus extends AbstractJT808MsgBodyEncoder[JT1078Msg_9105_LiveAVStatus] {
  override protected def encodeBody(m: JT1078Msg_9105_LiveAVStatus, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getChannelId)
    out.writeByte(p.getLossRate)
  }
}
