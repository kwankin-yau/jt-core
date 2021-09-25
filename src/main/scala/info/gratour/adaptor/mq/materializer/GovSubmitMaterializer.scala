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
import info.gratour.common.error.{ErrorWithCode, Errors}
import info.gratour.jtmodel.alm.{AlmProcRpt, AlmRpt}
import info.gratour.jtmodel.govsubmit.{GovSubmitMsg, SafetyTermInstall}

class GovSubmitMaterializer extends JsonDeserializer[GovSubmitMsg] {
  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): GovSubmitMsg = {
    val obj = json.getAsJsonObject
    val r = new GovSubmitMsg

    if (obj.has("typ"))
      r.setTyp(obj.getAsJsonPrimitive("typ").getAsInt)

    if (obj.has("msg")) {
      r.getTyp match {
        case GovSubmitMsg.TYP__ALM_RPT =>
          r.setMsg(context.deserialize(obj.get("msg"), classOf[AlmRpt]))

        case GovSubmitMsg.TYP__ALM_PROC_RPT =>
          r.setMsg(context.deserialize(obj.get("msg"), classOf[AlmProcRpt]))

        case GovSubmitMsg.TYP__SAFETY_TERM_INST =>
          r.setMsg(context.deserialize(obj.get("msg"), classOf[SafetyTermInstall]))

        case _ =>
          throw new ErrorWithCode(Errors.NOT_SUPPORTED, "typ=" + r.getTyp)
      }
    }

    r
  }
}
