/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.encoder.impl

import info.gratour.common.error.ErrorWithCode
import info.gratour.common.utils.StringUtils
import info.gratour.jt808core.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808core.protocol.msg.JT808Msg_8701_VTDRSetParams
import info.gratour.jt808core.protocol.msg.types.vtdr.{JT808VTDR_Mileage_03, JT808VTDR_PulseFactor_04, JT808VTDR_Time_02, JT808VTDR_VehInfo_05, VTDR_StatusSignalNames}
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

object MBEncoder808_8701_VTDRSetParams extends AbstractJT808MsgBodyEncoder[JT808Msg_8701_VTDRSetParams] {

  override protected def encodeBody(m: JT808Msg_8701_VTDRSetParams, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    def writeDateTime(s: String, paramName: String): Unit = {
      val hex = Hex.decodeHex(s)
      if (hex.length != 6)
        throw ErrorWithCode.invalidParam(paramName)
      out.writeBytes(hex)
    }

    def writeBcd8Num(v: Int, paramName: String): Unit = {
      val s = StringUtils.leftPad(v.toString, 8, '0')
      if (s.length > 8)
        throw ErrorWithCode.invalidParam(paramName)
      out.writeBytes(Hex.decodeHex(s))
    }

    out.writeByte(p.getCmd)
    val data = p.getDataBlock
    if (data != null) {
      data match {
        case d: JT808VTDR_VehInfo_05 =>
          out.writeFixedLenStr(d.getVin, 17)
          out.writeFixedLenStr(d.getPlateNo, 12)
          out.writeFixedLenStr(d.getPlateCategory, 12)

        case d: JT808VTDR_Time_02 =>
          writeDateTime(d.getDateTime, "params.dateTime")

        case d: VTDR_StatusSignalNames =>
          val list = d.getBitDesc
          if (list == null || list.size() != 8)
            throw ErrorWithCode.invalidParam("params.bitDesc")

          list.forEach(s => {
            out.writeFixedLenStr(s, 10)
          })

        case d: JT808VTDR_PulseFactor_04 =>
          writeDateTime(d.getDateTime, "params.dateTime")
          out.writeShort(d.getFactor)

        case d: JT808VTDR_Mileage_03 =>
          writeDateTime(d.getDateTime, "params.dateTime")
          writeDateTime(d.getInstallTime, "params.installTime")
          writeBcd8Num((d.getInitMile * 10).toInt, "params.initMile")
          writeBcd8Num((d.getMile * 10).toInt, "params.mile")

        case _ =>
          throw ErrorWithCode.internalError("Unrecognized dataBlock: " + data)
      }
    }
  }
}
