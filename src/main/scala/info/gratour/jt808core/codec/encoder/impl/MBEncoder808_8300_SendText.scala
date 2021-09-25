/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.encoder.impl

import info.gratour.jt808core.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808core.protocol.msg.JT808Msg_8300_SendText
import io.netty.buffer.ByteBuf

object MBEncoder808_8300_SendText extends AbstractJT808MsgBodyEncoder[JT808Msg_8300_SendText] {
  override protected def encodeBody(m: JT808Msg_8300_SendText, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")
    checkNotNull(params.getOpts, "opts")
    checkNotNull(params.getText, "text")

    out.writeByte(params.getOpts)
    out.writeStr(params.getText)
  }
}
