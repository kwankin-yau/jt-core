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
import info.gratour.jtmodel.govissue.{AlmSupervise, GovInspectAck, GovIssueAckMsg}

class GovIssueAckMaterializer extends JsonDeserializer[GovIssueAckMsg] {
  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): GovIssueAckMsg = {
    val obj = json.getAsJsonObject
    val r = new GovIssueAckMsg

    if (obj.has("typ"))
      r.setTyp(obj.get("typ").getAsInt)

    if (obj.has("msg")) {
      r.getTyp match {
        case GovIssueAckMsg.TYP__GOV_INSPECT_ACK =>
          r.setMsg(context.deserialize(obj.get("msg"), classOf[GovInspectAck]))

        case GovIssueAckMsg.TYP__ALM_SUPERVISE_ACK =>
          r.setMsg(context.deserialize(obj.get("msg"), classOf[AlmSupervise]))

        case _ =>
          throw new ErrorWithCode(Errors.NOT_SUPPORTED, "typ=" + r.getTyp)
      }
    }

    r
  }
}
