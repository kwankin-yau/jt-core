/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.decoder.impl

import info.gratour.jt808core.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808core.protocol.msg.JT808Msg_0900_PassThroughUL
import info.gratour.adaptor.mq.dto.types.MQEventAddt_0900_PassThroughUL
import io.netty.buffer.ByteBuf

object MBDecoder808_0900_PassThroughUL extends JT808MsgBodyDecoder[JT808Msg_0900_PassThroughUL] {

  override def decodeMsgBody(m: JT808Msg_0900_PassThroughUL, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val data = new MQEventAddt_0900_PassThroughUL
    data.setTyp(body.readByte())
    data.setData(body.readRemainingAsBytes())
    m.setData(data)
  }

}
