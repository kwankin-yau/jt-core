/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.mq.materializer

import java.lang.reflect.Type

import com.google.gson.{JsonDeserializationContext, JsonDeserializer, JsonElement}
import info.gratour.adaptor.mq.dto.RtRgnChange
import info.gratour.common.error.ErrorWithCode
import info.gratour.jtmodel.rgn.{PlatRgn, TermRgn}
import info.gratour.jtmodel.route.Route

class RtRgnChangeMaterializer extends JsonDeserializer[RtRgnChange]{
  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): RtRgnChange = {
    val o = json.getAsJsonObject
    val r = new RtRgnChange
    r.setId(o.get("id").getAsString)
    r.setTyp(o.get("typ").getAsString)
    r.setSimNo(o.get("simNo").getAsString)
    r.setEnabled(o.get("enabled").getAsBoolean)

    val params = o.get("params")

    if (params != null) {
      r.getTyp match {
        case RtRgnChange.TYP__ROUTE =>
          val route: Route = context.deserialize(params, classOf[Route])
          r.setParams(route)

        case RtRgnChange.TYP__REGION =>
          val rgn: TermRgn = context.deserialize(params, classOf[TermRgn])
          r.setParams(rgn)

        case RtRgnChange.TYP__PLAT_RGN =>
          val platRgn: PlatRgn = context.deserialize(params, classOf[PlatRgn])
          r.setParams(platRgn)
        //        r.setParams(null)

        case _ =>
          throw ErrorWithCode.internalError(s"Unhandled RtRgnChange.typ: ${r.getTyp}")
      }
    }

    r
  }
}
