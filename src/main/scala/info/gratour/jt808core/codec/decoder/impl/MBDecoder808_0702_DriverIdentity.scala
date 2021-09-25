/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.decoder.impl

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import info.gratour.jt808core.JT808Utils
import info.gratour.jt808core.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808core.protocol.msg.JT808Msg_0702_DriverIdentity
import info.gratour.adaptor.mq.dto.types.MQEventAddt_0702_DriverIdentity
import io.netty.buffer.ByteBuf

object MBDecoder808_0702_DriverIdentity extends JT808MsgBodyDecoder[JT808Msg_0702_DriverIdentity]{

  private def parseMsgBodyOldFormat(m: JT808Msg_0702_DriverIdentity, body: ByteBuf): Unit = {
    val p = new MQEventAddt_0702_DriverIdentity
    p.setState(MQEventAddt_0702_DriverIdentity.ACT__LOGIN)
    p.setTime(System.currentTimeMillis())
    p.setReadState(MQEventAddt_0702_DriverIdentity.READ_STATE__OK)
    p.setDriverName(body.readByteLenPrefixedStr())
    body.skipBytes(20)
    p.setLicenseNo(body.readStrMaxLen(40))
    p.setIssuer(body.readByteLenPrefixedStr())
    val date = LocalDate.now().plusYears(3)
    p.setExpireDate(date.format(DateTimeFormatter.ISO_LOCAL_DATE))

    m.setInfo(p)
  }

  override def decodeMsgBody(m: JT808Msg_0702_DriverIdentity, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val pos = body.readerIndex()
    try {
      val p = new MQEventAddt_0702_DriverIdentity
      p.setState(body.readByte())
      body.readBytes(tempBuf, 0, 6)
      p.setTime(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
      if (p.getState == MQEventAddt_0702_DriverIdentity.ACT__LOGIN && body.isReadable) {
        p.setReadState(body.readUnsignedByte())
        p.setDriverName(body.readByteLenPrefixedStr())
        p.setLicenseNo(body.readStrMaxLen(20))
        p.setIssuer(body.readByteLenPrefixedStr())
        body.readBytes(tempBuf, 0, 4)
        val expireDate = JT808Utils.bcd4ToLocalDate(tempBuf, 0)
        p.setExpireDate(expireDate.format(DateTimeFormatter.ISO_LOCAL_DATE))
      }

      m.setInfo(p)
    } catch {
      case t: Throwable =>
        // try parse old format
        body.readerIndex(pos)
        try {
          parseMsgBodyOldFormat(m, body)
        } catch {
          case _: Throwable =>
            throw t
        }
    }
  }
}
