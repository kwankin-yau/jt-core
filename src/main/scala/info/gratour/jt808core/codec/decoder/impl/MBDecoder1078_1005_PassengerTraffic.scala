/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.decoder.impl

import info.gratour.jt808core.JT808Utils
import info.gratour.jt808core.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808core.protocol.msg.JT1078Msg_1005_PassengerTraffic
import info.gratour.adaptor.mq.dto.types.MQEventAddt_1005_PassengerTraffic
import io.netty.buffer.ByteBuf

object MBDecoder1078_1005_PassengerTraffic extends JT808MsgBodyDecoder[JT1078Msg_1005_PassengerTraffic] {
  override def decodeMsgBody(m: JT1078Msg_1005_PassengerTraffic, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val data = new MQEventAddt_1005_PassengerTraffic
    body.readBytes(tempBuf, 0, 6)
    data.setStartTime(JT808Utils.bcd6ToTimestamp(tempBuf, 0))

    body.readBytes(tempBuf, 0, 6)
    data.setEndTime(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
    data.setGetOnCount(body.readUnsignedShort())
    data.setGetOffCount(body.readUnsignedShort())

    m.setData(data)
  }
}
