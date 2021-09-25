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
import info.gratour.adaptor.mq.dto.gateway.{GatewayReq, GatewayResp, GatewayRespObject, TermConnState}
import info.gratour.common.error.{ErrorWithCode, Errors}

class GatewayRespMaterializer extends JsonDeserializer[GatewayResp] {

  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): GatewayResp = {
    val o = json.getAsJsonObject
    val r = new GatewayResp
    r.setReqId(o.get("reqId").getAsString)
    r.setTyp(o.get("typ").getAsString)
    if (o.has("resp")) {
      val resp = o.get("resp").getAsJsonArray

      r.getTyp match {
        case GatewayReq.TYP__conn_state =>
          resp.forEach(e => {
            val connState = context.deserialize[TermConnState](e, classOf[TermConnState])
            r.addRespObject(connState)
          })

        case _ =>
          throw new ErrorWithCode(Errors.INVALID_PARAM, s"Unrecognized gateway request type: `${r.getTyp}`.")
      }
    }

    r
  }

}
