/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.impl

import java.lang.reflect.Type
import java.util

import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.AVResRepo
import info.gratour.adaptor.impl.AVResRepoApiImpl.{AV_RES_PATH, AV_RES_REPLY_TYPE}
import info.gratour.adaptor.types.UpdateAVResReq
import info.gratour.common.types.EpochMillis
import info.gratour.common.types.rest.{Pagination, Reply}
import info.gratour.jtmodel.AVRes

class AVResRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends AVResRepo with APIClient {

//  override def createAVRes(req: CreateAVResReq): AVRes =
//    checkReply(post[AVRes](AVResRepoApiImpl.AV_RES_PATH, AVResRepoApiImpl.AV_RES_REPLY_TYPE, req)).firstOrNull()
  override def updateAVRes(req: UpdateAVResReq): Boolean = {
    checkReply(put(AVResRepoApiImpl.AV_RES_PATH, req)).ok()
  }

  override def qryAVRes(plateNo: String, plateColor: Short, channelId: Byte, startTime: Long, endTime: Long): util.List[AVRes] = {
    checkReply(
      getParamsOpt[AVRes](
        AV_RES_PATH,
        AV_RES_REPLY_TYPE,
        "plateNo" -> Some(plateNo),
        "plateColor" -> Some(plateColor),
        "startTm" -> Some(EpochMillis(startTime)),
        "endTm" -> (if (endTime != 0) Some(EpochMillis(endTime)) else None),
        "chan" -> (if (channelId != 0) Some(channelId) else None)
      )(Pagination(500, 1))
    ).dataList()
  }
}

object AVResRepoApiImpl {
  val AV_RES_PATH = "av_res"
  val AV_RES_REPLY_TYPE: Type = new TypeToken[Reply[AVRes]](){}.getType
}
