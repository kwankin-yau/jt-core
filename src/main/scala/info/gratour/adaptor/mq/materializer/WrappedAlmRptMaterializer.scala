/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.mq.materializer

import java.lang.reflect.Type

import com.google.gson.{JsonElement, JsonObject, JsonSerializationContext, JsonSerializer}
import info.gratour.jtmodel.alm.{WrappedAlmRptClose, WrappedAlmRptCreate}

class WrappedAlmRptCreateSerializer extends JsonSerializer[WrappedAlmRptCreate] {
  override def serialize(src: WrappedAlmRptCreate, typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
    val obj = new JsonObject
    val alm = src.getAlm
    obj.addProperty("id", alm.getId)
    obj.addProperty("plateNo", src.getPlateNo)
    obj.addProperty("plateColor", src.getPlateColor)
    obj.addProperty("grpId", src.getGrpId)
    obj.addProperty("st", 1) // alarm start
    obj.addProperty("src", alm.getSrc)
    obj.addProperty("typ", alm.getTyp)
    obj.addProperty("tm", alm.getTm1.millis)
    obj.addProperty("drvName", alm.getDrvName)
    obj.addProperty("drvNo", alm.getDrvNo)
    obj.addProperty("lvl", if (alm.getLvl != null) alm.getLvl.shortValue() else 0)
    obj.addProperty("lng", alm.getLng1)
    obj.addProperty("lat", alm.getLat1)
    obj.addProperty("alt", alm.getAlt1)
    obj.addProperty("spd", alm.getSpd1.toShort)
    val f = alm.getRecSpd1
    obj.addProperty("recSpd", if (f != null) f.shortValue() else 0)

    obj
  }
}

class WrappedAlmRptCloseSerializer extends JsonSerializer[WrappedAlmRptClose] {
  override def serialize(src: WrappedAlmRptClose, typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
    val obj = new JsonObject
    val alm = src.getAlm
    obj.addProperty("id", alm.getId)
    obj.addProperty("plateNo", src.getPlateNo)
    obj.addProperty("plateColor", src.getPlateColor)
    obj.addProperty("grpId", src.getGrpId)
    obj.addProperty("st", 2) // alarm close
    obj.addProperty("src", src.getSrc)
    obj.addProperty("typ", src.getTyp)
    obj.addProperty("tm", alm.getTm1.millis)
    obj.addProperty("drvName", src.getDrvName)
    obj.addProperty("drvNo", src.getDrvNo)
    obj.addProperty("lvl", if (src.getLvl != null) src.getLvl.shortValue() else 0)
    obj.addProperty("lng", alm.getLng0)
    obj.addProperty("lat", alm.getLat0)
    obj.addProperty("alt", alm.getAlt0)
    obj.addProperty("spd", alm.getSpd0.toShort)
    val f = alm.getRecSpd0
    obj.addProperty("recSpd", if (f != null) f.shortValue() else 0)
    obj
  }
}
