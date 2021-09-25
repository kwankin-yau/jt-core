/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.encoder.impl

import java.time.LocalDateTime

import info.gratour.common.error.ErrorWithCode
import info.gratour.common.utils.{BitUtils, DateTimeUtils}
import info.gratour.jt808core.JT808Utils
import info.gratour.jt808core.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808core.protocol.msg.JT808Msg_8604_SetPolygonRegion
import io.netty.buffer.ByteBuf

object MBEncoder808_8604_SetPolygonRegion extends AbstractJT808MsgBodyEncoder[JT808Msg_8604_SetPolygonRegion] {
  override protected def encodeBody(m: JT808Msg_8604_SetPolygonRegion, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")

    out.writeInt(params.getRegionId)
    val attrs = params.getAttrs
    out.writeShort(attrs)
    if (BitUtils.test(attrs, 0)) {
      if (params.getStartTm == null)
        throw ErrorWithCode.invalidParam("startTm")
      if (params.getEndTm == null)
        throw ErrorWithCode.invalidParam("endTm")

      var ldt = JT808Utils.parseSixDigitsDateTime(params.getStartTm)
      out.writeBytes(ldt.toBcd6)
      ldt = JT808Utils.parseSixDigitsDateTime(params.getEndTm)
      out.writeBytes(ldt.toBcd6)
    }

    if (BitUtils.test(attrs, 1)) {
      if (params.getSpdUpperLimit == null)
        throw ErrorWithCode.invalidParam("spdUpperLimit")

      if (params.getTimeThreshold == null)
        throw ErrorWithCode.invalidParam("timeThreshold")

      out.writeShort(params.getSpdUpperLimit.shortValue())
      out.writeByte(params.getTimeThreshold.byteValue())
    }

    val vectors = checkNotEmpty(params.getVectors, "vectors")
    out.writeShort(vectors.length)
    vectors.foreach(c => {
      out.writeAxis(c.getLat)
      out.writeAxis(c.getLng)
    })
  }
}
