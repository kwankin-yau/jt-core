/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.decoder.impl

import info.gratour.adaptor.mq.dto.types.MQEventAddt_0100_TermRegister
import info.gratour.jt808core.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808core.protocol.msg.JT808Msg_0100_TerminalRegister
import io.netty.buffer.ByteBuf

object MBDecoder808_0100_TerminalRegister extends JT808MsgBodyDecoder[JT808Msg_0100_TerminalRegister]{

  override def decodeMsgBody(m: JT808Msg_0100_TerminalRegister, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val addt = new MQEventAddt_0100_TermRegister
    addt.setProvinceId(body.readUnsignedShort())
    addt.setCityId(body.readUnsignedShort())
    addt.setFactoryId(body.readStr(5))
    if (body.readableBytes() > 28)
      addt.setTerminalModel(body.readStr(20))
    else
      addt.setTerminalModel(body.readStr(8))
    addt.setTerminalId(body.readStr(7))
    addt.setPlateColor(body.readByte())
    var s = body.readRemainingAsStr()
    val idx = s.lastIndexOf(0)
    if (idx > 0)
      s = s.substring(0, idx)
    else if (idx == 0)
      s = "";
    addt.setPlateNo(s)

    m.setInfo(addt)
  }

}
