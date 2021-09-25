/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.gnss.core.strmmediaapi

import java.lang.reflect.Type

import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.impl.{APIAuthentication, APIClient}
import info.gratour.adaptor.types.strm_media.{LiveStrmCtrlReq, VodStrmCtrlReq}
import info.gratour.common.types.rest.{RawReply, Reply}
import info.gratour.gnss.core.strmmediaapi.StrmMediaApi.{ChannelReportResult, TimedToken}
import okhttp3.Request

class StrmMediaApiClient(apiUrl: String) extends StrmMediaApi {

  private val client: APIClient = new APIClient {
    override def endPointUrl: String = apiUrl

    override def authentication: APIAuthentication = (builder: Request.Builder) => builder
  }

  override def createChannel(req: StrmMediaApi.CreateChannelReq): Reply[StrmMediaApi.CreateResult] =
    client.post[StrmMediaApi.CreateResult](StrmMediaApiClient.CREATE_API_PATH, StrmMediaApiClient.CREATE_RESULT_REPLY_TYPE, req)

  override def play(req: StrmMediaApi.PlayReq): RawReply =
    client.post(StrmMediaApiClient.PLAY_API_PATH, req)

  override def keepChannel(req: StrmMediaApi.KeepChannelReq): Reply[StrmMediaApi.KeepChannelItemResult] =
    client.post[StrmMediaApi.KeepChannelItemResult](StrmMediaApiClient.KEEP_API_PATH, StrmMediaApiClient.KEEP_ALIVE_RESULT_REPLY_TYPE, req)

  override def releaseChannel(req: StrmMediaApi.ReleaseChannelReq): RawReply =
    client.post(StrmMediaApiClient.RELEASE_API_PATH, req)

  /**
   *
   * @param req
   * @return OK or RECORD_NOT_FOUND
   */
  override def checkChannel(req: StrmMediaApi.CheckChannelReq): RawReply =
    client.post(StrmMediaApiClient.CHECK_API_PATH, req)

  override def checkCtrl(req: StrmMediaApi.CheckCtrlReq): Reply[StrmMediaApi.CheckCtrlResult] =
    client.post[StrmMediaApi.CheckCtrlResult](StrmMediaApiClient.CHECK_CTRL_API_PATH, StrmMediaApiClient.CHECK_CTRL_RESULT_REPLY_TYPE, req)

  override def liveCtrl(req: LiveStrmCtrlReq): Reply[StrmMediaApi.StrmCtrlResult] =
    client.post[StrmMediaApi.StrmCtrlResult](StrmMediaApiClient.LIVE_CTRL_API_PATH, StrmMediaApiClient.STRM_CTRL_RESULT_REPLY_TYPE, req)

  override def vodCtrl(req: VodStrmCtrlReq): Reply[StrmMediaApi.StrmCtrlResult] =
    client.post[StrmMediaApi.StrmCtrlResult](StrmMediaApiClient.VOD_CTRL_API_PATH, StrmMediaApiClient.STRM_CTRL_RESULT_REPLY_TYPE, req)

  override def report(): Reply[StrmMediaApi.ChannelReportResult] =
    client.get[ChannelReportResult](StrmMediaApiClient.REPORT_API_PATH, StrmMediaApiClient.CHANNEL_REPORT_REPLY_TYPE)

  override def getTokens: Reply[StrmMediaApi.TimedToken] =
    client.get[TimedToken](StrmMediaApiClient.TOKEN_PATH, StrmMediaApiClient.TOKEN_REPLY_TYPE)

  override def qryTrace(): Reply[StrmMediaApi.StrmTraceEntry] =
    client.get[StrmMediaApi.StrmTraceEntry](StrmMediaApiClient.TRACE_PATH, StrmMediaApiClient.TRACE_REPLY_TYPE)

  override def addTrace(simNo: String): Reply[StrmMediaApi.StrmTraceEntry] = {
    val req = StrmMediaApi.StrmTraceEntry(simNo, 0L)
    client.post[StrmMediaApi.StrmTraceEntry](StrmMediaApiClient.TRACE_PATH, StrmMediaApiClient.TRACE_REPLY_TYPE, req)
  }

  override def removeTrace(simNo: String): RawReply =
    client.delete(StrmMediaApiClient.TRACE_PATH, "simNo" -> simNo)

  override def qryGlobalAudioConfig(): Reply[StrmMediaApi.GlobalAudioConfig] =
    client.get[StrmMediaApi.GlobalAudioConfig](StrmMediaApiClient.GLOBAL_AUDIO_CONFIG_PATH, StrmMediaApiClient.GLOBAL_AUDIO_CONFIG_REPLY_TYPE)

  override def setGlobalAudioConfig(config: StrmMediaApi.GlobalAudioConfig): RawReply =
    client.put(StrmMediaApiClient.GLOBAL_AUDIO_CONFIG_PATH, config)

  override def qryTermAudioConfig(): Reply[StrmMediaApi.TermAudioConfig] =
    client.get[StrmMediaApi.TermAudioConfig](StrmMediaApiClient.TERM_AUDIO_CONFIG_PATH, StrmMediaApiClient.TERM_AUDIO_CONFIG_REPLY_TYPE)

  override def setTermAudioConfig(config: StrmMediaApi.TermAudioConfig): RawReply =
    client.post(StrmMediaApiClient.TERM_AUDIO_CONFIG_PATH, config)

  override def deleteTermAudioConfig(simNo: String): RawReply =
    client.delete(StrmMediaApiClient.TERM_AUDIO_CONFIG_PATH, "simNo" -> simNo)
}

object StrmMediaApiClient {
  val CREATE_API_PATH = "/create"
  val KEEP_API_PATH = "/keep"
  val PLAY_API_PATH = "/play"
  val RELEASE_API_PATH = "/release"
  val CHECK_API_PATH = "/check"
  val CHECK_CTRL_API_PATH = "/check_ctrl"
  val LIVE_CTRL_API_PATH = "/live_ctrl"
  val VOD_CTRL_API_PATH = "/vod_ctrl"
  val REPORT_API_PATH = "/report"
  val TOKEN_PATH = "/token"
  val TRACE_PATH = "/trace"
  val GLOBAL_AUDIO_CONFIG_PATH = "audio_config/global"
  val TERM_AUDIO_CONFIG_PATH = "audio_config/term"

  val CREATE_RESULT_REPLY_TYPE: Type = new TypeToken[Reply[StrmMediaApi.CreateResult]]() {}.getType
  val KEEP_ALIVE_RESULT_REPLY_TYPE: Type = new TypeToken[Reply[StrmMediaApi.KeepChannelItemResult]](){}.getType
  val CHECK_CTRL_RESULT_REPLY_TYPE: Type = new TypeToken[Reply[StrmMediaApi.CheckCtrlResult]](){}.getType
  val STRM_CTRL_RESULT_REPLY_TYPE: Type = new TypeToken[Reply[StrmMediaApi.StrmCtrlResult]](){}.getType
  val CHANNEL_REPORT_REPLY_TYPE: Type = new TypeToken[Reply[ChannelReportResult]](){}.getType
  val TOKEN_REPLY_TYPE: Type = new TypeToken[Reply[StrmMediaApi.TimedToken]](){}.getType
  val TRACE_REPLY_TYPE: Type = new TypeToken[Reply[StrmMediaApi.StrmTraceEntry]](){}.getType
  val GLOBAL_AUDIO_CONFIG_REPLY_TYPE: Type = new TypeToken[Reply[StrmMediaApi.GlobalAudioConfig]](){}.getType
  val TERM_AUDIO_CONFIG_REPLY_TYPE: Type = new TypeToken[Reply[StrmMediaApi.TermAudioConfig]](){}.getType
}
