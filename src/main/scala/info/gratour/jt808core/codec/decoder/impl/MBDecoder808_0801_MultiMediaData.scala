/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.decoder.impl

import info.gratour.adaptor.mq.dto.types.MQEventAddt_0801_MultiMediaData
import info.gratour.jt808core.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808core.protocol.msg.JT808Msg_0801_MultiMediaData
import io.netty.buffer.ByteBuf

object MBDecoder808_0801_MultiMediaData extends JT808MsgBodyDecoder[JT808Msg_0801_MultiMediaData] {

  override def decodeMsgBody(m: JT808Msg_0801_MultiMediaData, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val data = new MQEventAddt_0801_MultiMediaData
    data.setMediaId(body.readUnsignedInt())
    data.setTyp(body.readByte())
    data.setFmt(body.readByte())
    data.setEvtCode(body.readByte())
    data.setChan(body.readByte())

    val slice = body.slice(body.readerIndex(), 28)
    val t = MBDecoder808_Track.decodeTrack(m, slice, tempBuf, System.currentTimeMillis(), retransmit = false)
    data.setTrk(t)
    body.skipBytes(28)

    val size = body.readableBytes()
    val bytes = new Array[Byte](size)
    body.readBytes(bytes)

    data.setData(bytes)

    m.setData(data)
  }
}
