/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.encoder.impl

import info.gratour.jt808core.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808core.protocol.msg.JT1078Msg_9101_LiveAVReq
import io.netty.buffer.ByteBuf

object MBEncoder1078_9101_LiveAVReq extends AbstractJT808MsgBodyEncoder[JT1078Msg_9101_LiveAVReq] {
  override protected def encodeBody(m: JT1078Msg_9101_LiveAVReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByteLenPrefixedStr(checkNotNull(p.getServerIp, "serverIp"))
    out.writeShort(p.getTcpPort)
    out.writeShort(p.getUdpPort)
    out.writeByte(p.getChannel)
    out.writeByte(if (p.getDataType != null) p.getDataType.byteValue() else 0)
    out.writeByte(if (p.getCodeStream != null) p.getCodeStream.byteValue() else 0)
  }
}
