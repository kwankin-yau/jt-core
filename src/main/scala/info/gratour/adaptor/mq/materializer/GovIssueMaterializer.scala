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
import info.gratour.jtmodel.govissue.{AlmSupervise, GovInspect, GovIssueMsg}

class GovIssueMaterializer extends JsonDeserializer[GovIssueMsg] {

  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): GovIssueMsg = {
    val obj = json.getAsJsonObject
    val r = new GovIssueMsg
    if (obj.has("typ"))
      r.setTyp(obj.get("typ").getAsInt)
    if (obj.has("msg")) {
      r.getTyp match {
        case GovIssueMsg.TYP__GOV_INSPECT =>
          r.setMsg(context.deserialize(obj.get("msg"), classOf[GovInspect]))

        case GovIssueMsg.TYP__ALM_SUPERVISE =>
          r.setMsg(context.deserialize(obj.get("msg"), classOf[AlmSupervise]))
      }
    }

    r
  }
}
