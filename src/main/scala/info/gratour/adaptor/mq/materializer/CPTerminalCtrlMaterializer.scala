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
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_8105_TerminalCtrl
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_8105_TerminalCtrl.{Cmd1_WirelessUpgrade, Cmd2_ConnSpecialServer}

class CPTerminalCtrlMaterializer extends JsonDeserializer[CP_8105_TerminalCtrl] {
  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): CP_8105_TerminalCtrl = {
    val obj = json.getAsJsonObject
    val r = new CP_8105_TerminalCtrl

    if (obj.has("cmd")) {
      r.setCmd(obj.get("cmd").getAsInt)
    }

    if (obj.has("params")) {
      r.getCmd match {
        case CP_8105_TerminalCtrl.CMD__WIRELESS_UPGRADE =>
          r.setParams(context.deserialize(obj.get("params"), classOf[Cmd1_WirelessUpgrade]))

        case CP_8105_TerminalCtrl.CMD__CONNECT_TO_SPECIFIED_SERVER =>
          r.setParams(context.deserialize(obj.get("params"), classOf[Cmd2_ConnSpecialServer]))

        case _ =>
      }
    }

    r
  }
}
