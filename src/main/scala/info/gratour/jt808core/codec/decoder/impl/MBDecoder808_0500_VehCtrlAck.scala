/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.decoder.impl

import info.gratour.jt808core.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808core.protocol.msg.JT808Msg_0500_VehCtrlAck
import info.gratour.jt808core.protocol.msg.types.ackparams.JT808AckParams_0500_VehCtrlAck
import io.netty.buffer.ByteBuf

object MBDecoder808_0500_VehCtrlAck extends JT808MsgBodyDecoder[JT808Msg_0500_VehCtrlAck]{
  override def decodeMsgBody(m: JT808Msg_0500_VehCtrlAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    val t = MBDecoder808_Track.decodeTrack(m, body, tempBuf, System.currentTimeMillis(), retransmit = false)
    val ackParams = new JT808AckParams_0500_VehCtrlAck
    ackParams.setTrk(t)
    m.setAckParams(ackParams)
  }
}
