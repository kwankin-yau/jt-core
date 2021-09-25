/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.mq.materializer

import java.lang.reflect.Type

import com.google.gson._
import info.gratour.common.Consts
import info.gratour.jt808core.protocol.msg.types.cmdparams.CmdParamParser
import info.gratour.jtmodel.TermCmd

class TermCmdMaterializer extends JsonSerializer[TermCmd] with JsonDeserializer[TermCmd] {
  override def serialize(src: TermCmd, typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
    val obj = new JsonObject

    var l = src.getId
    if (l != 0)
      obj.addProperty("id", l)

    var s = src.getMsgId
    if (s != null)
      obj.addProperty("msgId", s)

    s = src.getSubCmdTyp
    if (s != null)
      obj.addProperty("subCmdType", s)

    s = src.getSimNo
    if (s != null)
      obj.addProperty("simNo", s)

    obj.addProperty("vehId", src.getVehId)

    s = src.getPlateNo
    if (s != null)
      obj.addProperty("plateNo", s)

    var i = src.getPlateColor
    if (i != null)
      obj.addProperty("plateColor", i)

    var epoch = src.getReqTm
    if (epoch != null)
      obj.addProperty("reqTm", epoch.millis)

    epoch = src.getSentTm
    if (epoch != null)
      obj.addProperty("sentTm", epoch.millis)

    epoch = src.getAckTm
    if (epoch != null)
      obj.addProperty("ackTm", epoch.millis)

    epoch = src.getEndTm
    if (epoch != null)
      obj.addProperty("endTm", epoch.millis)

    obj.addProperty("cmdSrc", src.getCmdSrc)
    obj.addProperty("status", src.getStatus)

    i = src.getMsgSn
    if (i != null)
      obj.addProperty("msgSn", i)

    i = src.getAckCode
    if (i != null)
      obj.addProperty("ackCode", i)

    val uid = src.getUserId
    if (uid != null)
      obj.addProperty("userId", uid.longValue())

    val params = src.getParams
    if (params != null)
      obj.add("params", context.serialize(params))

    obj
  }

  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): TermCmd = {
    val r = new TermCmd
    val obj = json.asInstanceOf[JsonObject]

    if (obj.has("id"))
      r.setId(obj.getAsJsonPrimitive("id").getAsLong)

    if (obj.has("msgId"))
      r.setMsgId(obj.getAsJsonPrimitive("msgId").getAsString)

    if (obj.has("subCmdType"))
      r.setSubCmdTyp(obj.getAsJsonPrimitive("subCmdType").getAsString)

    if (obj.has("simNo"))
      r.setSimNo(obj.getAsJsonPrimitive("simNo").getAsString)

    if (obj.has("vehId"))
      r.setVehId(obj.getAsJsonPrimitive("vehId").getAsLong)

    if (obj.has("plateNo"))
      r.setPlateNo(obj.getAsJsonPrimitive("plateNo").getAsString)

    if (obj.has("plateColor"))
      r.setPlateColor(obj.getAsJsonPrimitive("plateColor").getAsInt)

    if (obj.has("reqTm"))
      r.setReqTm(obj.getAsJsonPrimitive("reqTm").getAsLong)

    if (obj.has("sentTm"))
      r.setSentTm(obj.getAsJsonPrimitive("sentTm").getAsLong)

    if (obj.has("ackTm"))
      r.setAckTm(obj.getAsJsonPrimitive("ackTm").getAsLong)

    if (obj.has("endTm"))
      r.setEndTm(obj.getAsJsonPrimitive("endTm").getAsLong)

    if (obj.has("cmdSrc"))
      r.setCmdSrc(obj.getAsJsonPrimitive("cmdSrc").getAsInt)

    if (obj.has("status"))
      r.setStatus(obj.getAsJsonPrimitive("status").getAsInt)

    if (obj.has("msgSn"))
      r.setMsgSn(obj.getAsJsonPrimitive("msgSn").getAsInt)

    if (obj.has("ackCode"))
      r.setAckCode(obj.getAsJsonPrimitive("ackCode").getAsInt)

    if (obj.has("userId"))
      r.setUserId(obj.getAsJsonPrimitive("userId").getAsLong)

    if (obj.has("params")) {
      val json = obj.getAsJsonObject("params")
      val s = Consts.GSON.toJson(json)
      r.setParams(CmdParamParser.fromJson(r.msgIdToInt(), s))
    }

    r
  }
}
