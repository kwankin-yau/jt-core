/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.decoder.impl

import info.gratour.adaptor.mq.dto.types.MQEventAddt_0301_EventReport
import info.gratour.jt808core.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808core.protocol.msg.JT808Msg_0301_EventReport
import io.netty.buffer.ByteBuf

object MBDecoder808_0301_EventReport extends JT808MsgBodyDecoder[JT808Msg_0301_EventReport]{
  override def decodeMsgBody(m: JT808Msg_0301_EventReport, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val info = new MQEventAddt_0301_EventReport
    info.setEventId(body.readUnsignedByte())

    m.setInfo(info)
  }
}
