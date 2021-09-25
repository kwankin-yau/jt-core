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
import info.gratour.adaptor.mq.dto.Event
import info.gratour.adaptor.mq.dto.types.MQEventAddtParser
import info.gratour.common.error.{ErrorWithCode, Errors}

class EventMaterializer extends JsonSerializer[Event] with JsonDeserializer[Event] {

  override def serialize(src: Event, typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
    //    if (src == null)
    //      return JsonNull.INSTANCE

    val obj = new JsonObject
    var s = src.getMsgId
    if (s != null)
      obj.addProperty("msgId", s)
    s = src.getSimNo
    if (s != null)
      obj.addProperty("simNo", s)
    obj.addProperty("recvTm", src.getRecvTm)
    val addt = src.getAddt
    if (addt != null)
      obj.add("addt", context.serialize(addt))

    obj
  }

  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Event = {
    //    if (json.isJsonNull)
    //      return null

    val obj = json.asInstanceOf[JsonObject]
    if (!obj.has("msgId"))
      throw new ErrorWithCode(Errors.BAD_FORMAT, "Try to decode an Event object with no `msgId`.")

    val r = new Event
    r.setMsgId(obj.getAsJsonPrimitive("msgId").getAsString)
    if (obj.has("simNo"))
      r.setSimNo(obj.getAsJsonPrimitive("simNo").getAsString)
    if (obj.has("recvTm"))
      r.setRecvTm(obj.getAsJsonPrimitive("recvTm").getAsLong)

    if (obj.has("addt")) {
      val clzz = MQEventAddtParser.clazzOf(r.getMsgId)
      if (clzz != null) {
        r.setAddt(context.deserialize(obj.getAsJsonObject("addt"), clzz))
      }
      // else        throw new ErrorWithCode(Errors.BAD_FORMAT, s"Not recognized Event with msgId `${r.getMsgId}`.")
    }

    r
  }
}
