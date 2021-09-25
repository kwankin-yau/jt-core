package info.gratour.jtcommon

import java.nio.charset.Charset
import java.time.format.DateTimeFormatter
import java.time.{ZoneId, ZoneOffset}

import com.google.gson.{Gson, GsonBuilder}
import info.gratour.adaptor.mq.dto.gateway.{GatewayReq, GatewayResp}
import info.gratour.adaptor.mq.dto.{CmdAck, Event, RtRgnChange}
import info.gratour.adaptor.mq.materializer.{CPTerminalCtrlMaterializer, CmdAckMaterializer, EventMaterializer, GatewayReqMaterializer, GatewayRespMaterializer, GovIssueAckMaterializer, GovIssueMaterializer, GovSubmitMaterializer, RtRgnChangeMaterializer, TermCmdMaterializer, WrappedAlmRptCloseSerializer, WrappedAlmRptCreateSerializer}
import info.gratour.common.types.EpochMillis
import info.gratour.common.types.json.EpochMillisMaterializer
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_8105_TerminalCtrl
import info.gratour.jtmodel.TermCmd
import info.gratour.jtmodel.alm.{WrappedAlmRptClose, WrappedAlmRptCreate}
import info.gratour.jtmodel.govissue.{GovIssueAckMsg, GovIssueMsg}
import info.gratour.jtmodel.govsubmit.GovSubmitMsg

object JTConsts {

  val DEFAULT_CHARSET: Charset = Charset.forName("GBK")
  val ZONE_ID_Z: ZoneId = ZoneId.of("Z")

  val ZONE_OFFSET_BEIJING: ZoneOffset = ZoneOffset.ofHours(8)

  val ZERO_BYTE_ARRAY_32: Array[Byte] = Array.fill(32)(0)

  val BCD_DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss")

  object FileStorageBucketNames {
    val AlmAtt = "almatt"
    val MultiMedia = "mm"
    val AVRes = "avres"
  }

  def GSON_BUILDER: GsonBuilder = new GsonBuilder()
    .registerTypeAdapter(classOf[EpochMillis], new EpochMillisMaterializer)
    .registerTypeAdapter(classOf[TermCmd], new TermCmdMaterializer)
    .registerTypeAdapter(classOf[CP_8105_TerminalCtrl], new CPTerminalCtrlMaterializer)
    .registerTypeAdapter(classOf[CmdAck], new CmdAckMaterializer)
    .registerTypeAdapter(classOf[Event], new EventMaterializer)
    .registerTypeAdapter(classOf[WrappedAlmRptCreate], new WrappedAlmRptCreateSerializer)
    .registerTypeAdapter(classOf[WrappedAlmRptClose], new WrappedAlmRptCloseSerializer)
    .registerTypeAdapter(classOf[GovSubmitMsg], new GovSubmitMaterializer)
    .registerTypeAdapter(classOf[GovIssueMsg], new GovIssueMaterializer)
    .registerTypeAdapter(classOf[GovIssueAckMsg], new GovIssueAckMaterializer)
    .registerTypeAdapter(classOf[GatewayReq], new GatewayReqMaterializer)
    .registerTypeAdapter(classOf[GatewayResp], new GatewayRespMaterializer)
    .registerTypeAdapter(classOf[RtRgnChange], new RtRgnChangeMaterializer)

  val GSON: Gson = GSON_BUILDER.create()
  val GSON_PRETTY: Gson = GSON_BUILDER.setPrettyPrinting().create()
}
