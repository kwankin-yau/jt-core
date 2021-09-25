/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.gnss.core.strmmediaapi

import java.util.concurrent.Future

import info.gratour.adaptor.types.strm_media.{LiveStrmCtrlReq, ServerHint, VodStrmCtrlReq}
import info.gratour.common.types.rest.{RawReply, Reply}
import info.gratour.common.utils.StringUtils
import info.gratour.gnss.core.strmmediaapi.StrmMediaApi.ChannelReportResult
import info.gratour.jtcommon.JTUtils

trait StrmMediaApi {

  def getTokens: Reply[StrmMediaApi.TimedToken]

  def createChannel(req: StrmMediaApi.CreateChannelReq): Reply[StrmMediaApi.CreateResult]

  def play(req: StrmMediaApi.PlayReq): RawReply

  def keepChannel(req: StrmMediaApi.KeepChannelReq): Reply[StrmMediaApi.KeepChannelItemResult]

  /**
   *
   * @param req
   * @return OK or RECORD_NOT_FOUND
   */
  def checkChannel(req: StrmMediaApi.CheckChannelReq): RawReply

  def checkCtrl(req: StrmMediaApi.CheckCtrlReq): Reply[StrmMediaApi.CheckCtrlResult]

  def liveCtrl(req: LiveStrmCtrlReq): Reply[StrmMediaApi.StrmCtrlResult]

  def vodCtrl(req: VodStrmCtrlReq): Reply[StrmMediaApi.StrmCtrlResult]

  def releaseChannel(req: StrmMediaApi.ReleaseChannelReq): RawReply

  def report(): Reply[ChannelReportResult]

  def qryTrace(): Reply[StrmMediaApi.StrmTraceEntry]

  def addTrace(simNo: String): Reply[StrmMediaApi.StrmTraceEntry]

  def removeTrace(simNo: String): RawReply

  def qryGlobalAudioConfig(): Reply[StrmMediaApi.GlobalAudioConfig]

  def setGlobalAudioConfig(config: StrmMediaApi.GlobalAudioConfig): RawReply

  def qryTermAudioConfig(): Reply[StrmMediaApi.TermAudioConfig]

  def setTermAudioConfig(config: StrmMediaApi.TermAudioConfig): RawReply

  def deleteTermAudioConfig(simNo: String): RawReply
}

trait StrmMediaAsyncApi {

  def getTokens: Future[Reply[StrmMediaApi.TimedToken]]

  def createChannel(req: StrmMediaApi.CreateChannelReq): Future[Reply[StrmMediaApi.CreateResult]]

  def play(req: StrmMediaApi.PlayReq): Future[RawReply]

  def keepChannel(req: StrmMediaApi.KeepChannelReq): Future[Reply[StrmMediaApi.KeepChannelItemResult]]

  def checkChannel(req: StrmMediaApi.CheckChannelReq): Future[RawReply]

  def checkCtrl(req: StrmMediaApi.CheckCtrlReq): Future[Reply[StrmMediaApi.CheckCtrlResult]]

  def liveCtrl(req: LiveStrmCtrlReq): Future[Reply[StrmMediaApi.StrmCtrlResult]]

  def vodCtrl(req: VodStrmCtrlReq): Future[Reply[StrmMediaApi.StrmCtrlResult]]


  def releaseChannel(req: StrmMediaApi.ReleaseChannelReq): Future[RawReply]

  def report(): Future[Reply[ChannelReportResult]]

  def qryTrace(): Future[Reply[StrmMediaApi.StrmTraceEntry]]

  def addTrace(simNo: String): Future[Reply[StrmMediaApi.StrmTraceEntry]]

  def removeTrace(simNo: String): Future[RawReply]

  def qryGlobalAudioConfig(): Future[Reply[StrmMediaApi.GlobalAudioConfig]]

  def setGlobalAudioConfig(config: StrmMediaApi.GlobalAudioConfig): Future[RawReply]


  def qryTermAudioConfig(): Future[Reply[StrmMediaApi.TermAudioConfig]]

  def setTermAudioConfig(config: StrmMediaApi.TermAudioConfig): Future[RawReply]

  def deleteTermAudioConfig(simNo: String): Future[RawReply]
}

object StrmMediaApi {

  val PROTO__HTTP_FLV = 0
  val PROTO__RTMP = 1
  val PROTO__HLS = 2

  val CHANNEL_TYPE__LIVE = "live"
  val CHANNEL_TYPE__REPLAY = "replay"

  val TIMED_TOKEN_TYP__SUPERVISOR = "supervisor"
  val TIMED_TOKEN_TYP__FOREIGN = "foreign"
  val TIMED_TOKEN_TYP__CLIENT = "client"

  val USER_GRADE__GOV = 80
  val USER_GRADE__ADMIN = 50
  val USER_GRADE__NORMAL = 30

  case object GetTokensQry

  case class TimedToken(typ: String, token: String, expiredAt: Long)

  case class UpdateTimedTokenReq(tokens: java.util.List[TimedToken]) {
    def tokenByType(typ: String): String = {
      for (i <- 0 until tokens.size()) {
        val t = tokens.get(i)
        if (t.typ == typ)
          return t.token
      }

      null
    }

    def supervisorToken: String = tokenByType(TIMED_TOKEN_TYP__SUPERVISOR)

    def foreignToken: String = tokenByType(TIMED_TOKEN_TYP__FOREIGN)

    def clientToken: String = tokenByType(TIMED_TOKEN_TYP__CLIENT)
  }

  case class StrmUserInfo(userId: String, userGrade: Int) {
    def isAdmin: Boolean = userGrade == USER_GRADE__ADMIN

    def isGov: Boolean = userGrade == USER_GRADE__GOV
  }

  case class CreateChannelReq(reqId: String
                              , callback: String
                              , user: StrmMediaApi.StrmUserInfo
                              , typ: String
                              , simNo: String
                              , channelId: Short
                              , proto: Byte
                              , connIdx: Byte
                              , disableAudio: Boolean
                              , clientData: String) {
    def isLive: Boolean = typ == CHANNEL_TYPE__LIVE

    def streamName: String = encodeStreamName(simNo, channelId, isLive)

    /**
     * Validate the request parameters.
     *
     * @return error message, null for OK.
     */
    def validate: String = {
      if (user == null)
        return "user"


      if (typ != CHANNEL_TYPE__LIVE && typ != CHANNEL_TYPE__REPLAY)
        return "typ"

      if (StringUtils.isNullOrEmpty(simNo) || simNo.contains(':'))
        return "simNo"

      null
    }
  }

  case class CreateResult(
                           reqId: String,
                           ctrl: Boolean,
                           strmReady: Boolean,
                           playUrl: String,
                           keepIntervalSeconds: Int,
                           host: String,
                           port: Int,
                           tcp: Boolean
                         )

  case class KeepChannelReq(reqIds: Array[String], strmServerHint: ServerHint)

  //  case class SingleKeepChannelReq(cmdId: String)

  case class KeepChannelItemResult(reqId: String, keep: Boolean)

  case class ReleaseChannelReq(reqId: String)

  case class CheckChannelReq(reqId: String)

  case class PlayReq(simNo: String, channelId: Short, live: Boolean)

  case class CheckCtrlReq(reqId: String)

  case class CheckCtrlResult(reqId: String, ctrl: Boolean, simNo: String, channelId: Short, live: Boolean)

  case class StrmCtrlResult(reqId: String, ctrl: Boolean, simNo: String, channelId: Short, live: Boolean)


  case object ChannelReportReq

  case class ReqStat(reqId: String, userId: String, requestTime: String)

  case class ChannelStat(simNo: String,
                         channelId: Short,
                         live: Boolean,
                         audioDisabled: Boolean,
                         createTime: String,
                         started: Boolean,
                         strmReady: Boolean,
                         strmClosed: Boolean,
                         closeCause: Int,
                         recvFromTerm: Long, recvSpsCount: Long, sendToServer: Long,
                         audioFormat: String,
                         videoFormat: String,
                         requests: Array[ReqStat])

  case class ChannelReportResult(reportTime: String, channels: Array[ChannelStat])

  def encodeStreamName(simNo: String, chan: Short, live: Boolean): String =
    JTUtils.normalizeSimNo(simNo) + "_" + chan + "_" + (if (live) "1" else "0")

  def decodeStreamName(streamName: String): (String, Short, Boolean) = {
    val arr = streamName.split("_")
    (arr(0), arr(1).toShort, arr(2).toInt != 0)
  }


  case class StrmTraceEntry(simNo: String, startTraceTime: Long)

  case class GlobalAudioConfig(enabled: Boolean)

  case class TermAudioConfig(simNo: String, enabled: Boolean)

}


