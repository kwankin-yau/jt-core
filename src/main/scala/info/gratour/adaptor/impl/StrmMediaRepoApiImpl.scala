/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.adaptor.impl

import java.lang.reflect.Type
import java.util

import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.StrmMediaRepo
import info.gratour.adaptor.types.strm_media.{AcquireLiveStrmReq, AcquireLiveStrmResult, AcquireVodStrmReq, AcquireVodStrmResult, LiveStrmCtrlReq, StrmMediaKeepAliveResult, VodStrmCtrlReq}
import info.gratour.common.types.rest.Reply
import info.gratour.gnss.core.strmmediaapi.StrmMediaApi

class StrmMediaRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends StrmMediaRepo with APIClient {

  override def updateTokens(tokens: util.List[StrmMediaApi.TimedToken]): Unit = {
    val req = StrmMediaApi.UpdateTimedTokenReq(tokens)
    checkReply(post(StrmMediaRepoApiImpl.STRM_MEDIA_PATH, req))
  }

  override def keepAlive(reqIds: util.List[String]): util.List[StrmMediaKeepAliveResult] =
    checkReply(post[StrmMediaKeepAliveResult](
      StrmMediaRepoApiImpl.KEEP_ALIVE_PATH,
      StrmMediaRepoApiImpl.KEEP_ALIVE_REPLY_TYPE,
      reqIds
    )).dataList()

  override def liveAcquire(req: AcquireLiveStrmReq): AcquireLiveStrmResult =
    checkReply(post[AcquireLiveStrmResult](
      StrmMediaRepoApiImpl.LIVE_ACQUIRE_PATH,
      StrmMediaRepoApiImpl.LIVE_ACQUIRE_REPLY_TYPE,
      req
    )).first()

  override def liveCtrl(req: LiveStrmCtrlReq): Int =
    post(
      StrmMediaRepoApiImpl.LIVE_CTRL_PATH,
      req).getErrCode


  override def vodAcquire(req: AcquireVodStrmReq): AcquireVodStrmResult =
    checkReply(post[AcquireVodStrmResult](
      StrmMediaRepoApiImpl.VOD_ACQUIRE_PATH,
      StrmMediaRepoApiImpl.VOD_ACQUIRE_REPLY_TYPE,
      req
    )).first()

  override def vodCtrl(req: VodStrmCtrlReq): Int =
    post(
      StrmMediaRepoApiImpl.VOD_CTRL_PATH,
      req
    ).getErrCode

}

object StrmMediaRepoApiImpl {
  val STRM_MEDIA_PATH = "strm_media/token"

  val KEEP_ALIVE_PATH = "strm_media/keep_alive"
  val KEEP_ALIVE_REPLY_TYPE: Type = new TypeToken[Reply[StrmMediaKeepAliveResult]](){}.getType

  val LIVE_ACQUIRE_PATH = "strm_media/live/acquire"
  val LIVE_ACQUIRE_REPLY_TYPE: Type = new TypeToken[Reply[AcquireLiveStrmResult]](){}.getType

  val LIVE_CTRL_PATH = "strm_media/live/ctrl"

  val VOD_ACQUIRE_PATH = "strm_media/vod/acquire"
  val VOD_ACQUIRE_REPLY_TYPE: Type = new TypeToken[Reply[AcquireVodStrmResult]](){}.getType

  val VOD_CTRL_PATH = "strm_media/vod/ctrl"
}
