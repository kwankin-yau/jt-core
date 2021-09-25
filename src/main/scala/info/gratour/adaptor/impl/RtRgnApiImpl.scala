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
import info.gratour.adaptor.RtRgnRepo
import info.gratour.adaptor.types.{UpdateTermRgnSyncReq, UpdateTermRouteSyncReq}
import info.gratour.common.types.rest.{Pagination, Reply}
import info.gratour.jtmodel.rgn.{PlatRgn, TermRgn}
import info.gratour.jtmodel.route.{TermRoute, TermRouteNeedSync}

class RtRgnApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends RtRgnRepo with APIClient {

  override def markTermRouteSync(simNo: String, routeId: Long): Boolean = {
    val r = new UpdateTermRouteSyncReq
    r.setSimNo(simNo)
    r.setRouteId(routeId)

    checkReply(put(RtRgnApiImpl.TERM_ROUTE_SYNC_PATH, r)).ok()
  }

  override def qryTermRoutesNeedSync(): util.List[TermRouteNeedSync] = {
    checkReply(get[TermRouteNeedSync](RtRgnApiImpl.TERM_ROUTE_NEED_SYNC_PATH, RtRgnApiImpl.TERM_ROUTE_NEED_SYNC_TYPE)).dataList()
  }

  override def qryTermRgnsNeedSync(): util.List[TermRgn] =
    checkReply(get[TermRgn](RtRgnApiImpl.TERM_RGN_PATH, RtRgnApiImpl.TERM_RGN_TYPE, "sync" -> false)).dataList()

  override def markTermRgnSync(simNo: String, rgnId: Long): Boolean = {
    val r = new UpdateTermRgnSyncReq
    r.setSimNo(simNo)
    r.setRgnId(rgnId)

    checkReply(put(RtRgnApiImpl.TERM_RGN_SYNC_PATH, r)).ok()
  }

  override def qryPlatRgnEnabled(pagination: Pagination, withGrpsAndVehs: Boolean): Reply[PlatRgn] = {
    if (withGrpsAndVehs)
      checkReply(get[PlatRgn](RtRgnApiImpl.PLAT_RGN_PATH, RtRgnApiImpl.PLAT_RGN_TYPE, "__fields" -> "grps,vehs")(pagination))
    else
      checkReply(get[PlatRgn](RtRgnApiImpl.PLAT_RGN_PATH, RtRgnApiImpl.PLAT_RGN_TYPE)(pagination))
  }

  override def qryPlatRgnEnabled(platRgnId: String): PlatRgn =
    checkReply(get[PlatRgn](RtRgnApiImpl.PLAT_RGN_PATH, RtRgnApiImpl.PLAT_RGN_TYPE,
      "platRgnId" -> platRgnId,
      "__fields" -> "grps,vehs")).first()
}

object RtRgnApiImpl {
  val TERM_ROUTE_NEED_SYNC_PATH = "term_route/need_sync"
  val TERM_ROUTE_NEED_SYNC_TYPE: Type = new TypeToken[Reply[TermRouteNeedSync]]() {}.getType
  val TERM_ROUTE_TYPE: Type = new TypeToken[Reply[TermRoute]]() {}.getType
  val TERM_ROUTE_SYNC_PATH = "term_route/sync"

  val TERM_RGN_PATH = "term_rgn"
  val TERM_RGN_TYPE: Type = new TypeToken[Reply[TermRgn]]() {}.getType
  val TERM_RGN_SYNC_PATH = "term_rgn/sync"

  val PLAT_RGN_PATH = "plat_rgn"
  val PLAT_RGN_TYPE: Type = new TypeToken[Reply[PlatRgn]]() {}.getType
}
