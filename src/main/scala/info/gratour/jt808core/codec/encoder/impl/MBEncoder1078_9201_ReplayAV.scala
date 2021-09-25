/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.encoder.impl

import info.gratour.jt808core.JT808Utils
import info.gratour.jt808core.codec.CodecError
import info.gratour.jt808core.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808core.protocol.msg.JT1078Msg_9201_ReplayAVReq
import info.gratour.jtcommon.JTConsts
import io.netty.buffer.ByteBuf

object MBEncoder1078_9201_ReplayAV extends AbstractJT808MsgBodyEncoder[JT1078Msg_9201_ReplayAVReq] {
  override protected def encodeBody(m: JT1078Msg_9201_ReplayAVReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByteLenPrefixedStr(checkNotNull(p.getServerIp, "serverIp"))
    out.writeShort(p.getTcpPort)
    out.writeShort(p.getUdpPort)
    out.writeByte(p.getChannel)
    out.writeByte(p.getMediaType)
    out.writeByte(p.getCodeStream)
    out.writeByte(p.getStorageType)
    val mode = p.getMode
    val factor = p.getFactor
    mode match {
      case 1 | 2 =>
        if (factor == null)
          throw new CodecError("factor == null")

      case _ =>
    }
    out.writeByte(mode)
    out.writeByte(if (factor != null) factor.byteValue() else 0)
    out.writeBytes(JT808Utils.timestampToBcd6(p.getStartTime))
    if (p.getEndTime != null && p.getEndTime != 0L)
      out.writeBytes(JT808Utils.timestampToBcd6(p.getEndTime))
    else
      out.writeBytes(JTConsts.ZERO_BYTE_ARRAY_32, 0, 6)
  }
}
