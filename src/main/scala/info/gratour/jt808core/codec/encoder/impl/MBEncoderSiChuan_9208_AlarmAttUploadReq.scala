/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.encoder.impl

import info.gratour.jt808core.codec.CodecError
import info.gratour.jt808core.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808core.protocol.msg.JTSiChuanMsg_9208_AlmAttUploadReq
import info.gratour.jtcommon.JTConsts
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

object MBEncoderSiChuan_9208_AlarmAttUploadReq extends AbstractJT808MsgBodyEncoder[JTSiChuanMsg_9208_AlmAttUploadReq] {
  override protected def encodeBody(m: JTSiChuanMsg_9208_AlmAttUploadReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByteLenPrefixedStr(checkNotNull(p.getServerIp, "serverIp"))
    out.writeShort(p.getTcpPort)
    out.writeShort(p.getUdpPort)
    val bytes = Hex.decodeHex(checkNotNull(p.getAlmNo, "almNo"))
    if (bytes.length != 16)
      throw new CodecError("Invalid `almNo`.")
    out.writeBytes(bytes)
//    out.writeFixedLenStr(StringUtils.leftPad(p.getAlmId.toString, 32, '0'), 32)
    out.writeFixedLenStr(p.getAlmId.toString + ":" + p.getAlmTm1.toString, 32)
    out.writeBytes(JTConsts.ZERO_BYTE_ARRAY_32, 0, 16)
  }
}
