/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.mq.materializer

import java.lang.reflect.Type

import com.google.gson.{JsonDeserializationContext, JsonDeserializer, JsonElement, JsonObject, JsonSerializationContext, JsonSerializer}
import info.gratour.adaptor.mq.dto.CmdAck
import info.gratour.common.Consts
import info.gratour.jt808core.protocol.msg.types.ackparams.AckParamsParser

class CmdAckMaterializer extends JsonSerializer[CmdAck] with JsonDeserializer[CmdAck] {
  override def serialize(src: CmdAck, typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
    val obj = new JsonObject

    val l = src.getId
    if (l != 0)
      obj.addProperty("id", l)

    var str = src.getInitiateMsgId
    if (str != null)
      obj.addProperty("initiateMsgId", str)

    str = src.getSubCmdTyp
    if (str != null)
      obj.addProperty("subCmdType", str)

    str = src.getSimNo
    if (str != null)
      obj.addProperty("simNo", str)

    str = src.getPlateNo
    if (str != null)
      obj.addProperty("plateNo", str)

    obj.addProperty("plateColor", src.getPlateColor)

    str = src.getAckMsgId
    if (str != null)
      obj.addProperty("ackMsgId", str)

    var i = src.getAckSeqNo
    if (i != null)
      obj.addProperty("ackSeqNo", i)

    var epoch = src.getAckTm
    if (epoch != null)
      obj.addProperty("ackTm", epoch.millis)

    obj.addProperty("ok", src.isOk)

    i = src.getAckCode
    if (i != null)
      obj.addProperty("ackCode", i)

    obj.addProperty("cmdSrc", src.getCmdSrc)

    val ap = src.getAckParams
    if (ap != null) {
      obj.add("ackParams", context.serialize(ap))
    }

    obj
  }

  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): CmdAck = {
    val r = new CmdAck
    val obj = json.asInstanceOf[JsonObject]

    if (obj.has("id"))
      r.setId(obj.getAsJsonPrimitive("id").getAsLong)

    if (obj.has("initiateMsgId"))
      r.setInitiateMsgId(obj.getAsJsonPrimitive("initiateMsgId").getAsString)

    if (obj.has("subCmdType"))
      r.setSubCmdTyp(obj.getAsJsonPrimitive("subCmdType").getAsString)

    if (obj.has("simNo"))
      r.setSimNo(obj.getAsJsonPrimitive("simNo").getAsString)

    if (obj.has("plateNo"))
      r.setPlateNo(obj.getAsJsonPrimitive("plateNo").getAsString)

    if (obj.has("plateColor"))
      r.setPlateColor(obj.getAsJsonPrimitive("plateColor").getAsInt)

    if (obj.has("ackMsgId"))
      r.setAckMsgId(obj.getAsJsonPrimitive("ackMsgId").getAsString)

    if (obj.has("ackSeqNo"))
      r.setAckSeqNo(obj.getAsJsonPrimitive("ackSeqNo").getAsInt)

    if (obj.has("ackTm"))
      r.setAckTm(obj.getAsJsonPrimitive("ackTm").getAsLong)

    if (obj.has("ok"))
      r.setOk(obj.getAsJsonPrimitive("ok").getAsBoolean)

    if (obj.has("ackCode"))
      r.setAckCode(obj.getAsJsonPrimitive("ackCode").getAsInt)

    if (obj.has("cmdSrc"))
      r.setCmdSrc(obj.getAsJsonPrimitive("cmdSrc").getAsInt)

    if (obj.has("ackParams")) {
      val s = Consts.GSON.toJson(obj.getAsJsonObject("ackParams"))
      r.setAckParams(AckParamsParser.fromJson(r.ackMsgIdToInt(), s))
    }

    r
  }
}
