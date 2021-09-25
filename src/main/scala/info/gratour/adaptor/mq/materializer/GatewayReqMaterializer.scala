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
import info.gratour.adaptor.mq.dto.gateway.{GatewayReq, TermConnState}
import info.gratour.common.error.{ErrorWithCode, Errors}

class GatewayReqMaterializer extends JsonDeserializer[GatewayReq] {

  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): GatewayReq = {
    val o = json.getAsJsonObject
    val r = new GatewayReq
    r.setReqId(o.get("reqId").getAsString)
    r.setTyp(o.get("typ").getAsString)
    if (o.has("gw"))
      r.setGw(o.get("gw").getAsString)
    if (o.has("params")) {
      val params = o.get("params").getAsJsonObject
      r.getTyp match {
        case GatewayReq.TYP__conn_state =>
          r.setGatewayReqParams(context.deserialize(params, classOf[TermConnState]))

        case _ =>
          throw new ErrorWithCode(Errors.INVALID_PARAM, s"Unrecognized gateway request type: `${r.getTyp}`.")
      }
    }

    r
  }

}
