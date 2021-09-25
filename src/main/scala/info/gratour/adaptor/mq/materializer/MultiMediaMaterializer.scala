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
import info.gratour.jtmodel.MultiMedia
import info.gratour.jtmodel.trk.Trk

class MultiMediaMaterializer extends JsonSerializer[MultiMedia] with JsonDeserializer[MultiMedia] {
  override def serialize(src: MultiMedia, typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
    val o = new JsonObject

    val l = src.getId
    if (l != 0)
      o.addProperty("id", l)

    var str = src.getSimNo
    if (str != null)
      o.addProperty("simNo", str)

    val epoch = src.getRecvTm
    if (epoch != null)
      o.addProperty("recvTm", epoch.millis)
    o.addProperty("mediaId", src.getMediaId)
    o.addProperty("typ", src.getTyp)
    o.addProperty("fmt", src.getFmt)
    o.addProperty("evtCode", src.getEvtCode)
    o.addProperty("channel", src.getChan)

    val t = src.getTrk
    if (t != null)
      o.add("trk", context.serialize(t))

    str = src.getPath
    o.addProperty("data", src.getPath)

    o
  }

  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): MultiMedia = {
    val o = json.asInstanceOf[JsonObject]
    val r = new MultiMedia

    if (o.has("id"))
      r.setId(o.getAsJsonPrimitive("id").getAsLong)

    if (o.has("simNo"))
      r.setSimNo(o.getAsJsonPrimitive("simNo").getAsString)

    if (o.has("recvTm"))
      r.setRecvTm(o.getAsJsonPrimitive("recvTm").getAsLong)

    if (o.has("mediaId"))
      r.setMediaId(o.getAsJsonPrimitive("mediaId").getAsLong)

    if (o.has("typ"))
      r.setTyp(o.getAsJsonPrimitive("typ").getAsByte)

    if (o.has("fmt"))
      r.setFmt(o.getAsJsonPrimitive("fmt").getAsByte)

    if (o.has("evtCode"))
      r.setEvtCode(o.getAsJsonPrimitive("evtCode").getAsByte)

    if (o.has("channel"))
      r.setChan(o.getAsJsonPrimitive("channel").getAsByte)

    if (o.has("trk"))
      r.setTrk(context.deserialize(o.getAsJsonObject("trk"), Trk.TYPE))

    if (o.has("data"))
      r.setPath(o.getAsJsonPrimitive("data").getAsString)

    r
  }
}
