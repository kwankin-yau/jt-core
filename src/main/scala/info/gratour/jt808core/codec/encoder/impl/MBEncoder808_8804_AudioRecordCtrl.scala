/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.encoder.impl

import info.gratour.jt808core.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808core.protocol.msg.JT808Msg_8804_AudioRecordCtrl
import io.netty.buffer.ByteBuf

object MBEncoder808_8804_AudioRecordCtrl extends AbstractJT808MsgBodyEncoder[JT808Msg_8804_AudioRecordCtrl] {
  override protected def encodeBody(m: JT808Msg_8804_AudioRecordCtrl, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getAction)
    out.writeShort(p.getRecordTime)
    out.writeByte(p.getSaveFlag)
    out.writeByte(p.getSampleFrequency)
  }
}
