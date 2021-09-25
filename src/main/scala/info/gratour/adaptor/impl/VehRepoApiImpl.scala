/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.impl

import java.lang.reflect.Type
import java.{lang, util}

import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.VehRepo
import info.gratour.adaptor.impl.VehRepoApiImpl.MarkVehRegToGovReq
import info.gratour.adaptor.types.{PlateNoAndColor, VehCurrDrv}
import info.gratour.common.error.ErrorWithCode
import info.gratour.common.service.MemDbService
import info.gratour.common.types.rest.Reply
import info.gratour.jtmodel.VehBrief

class VehRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication, memDb: MemDbService) extends VehRepo with APIClient {

  private val vehCurrDrvCache = new VehCurrDrvCache(new VehCurrDrvMemDbRepo(memDb))

  override def getVehCurrDrv(vehId: Long): VehCurrDrv =
    vehCurrDrvCache.load(vehId)

  /**
   *
   * @param vehId      null if not use vehId condition
   * @param plateNo    null if not use plateNo condition
   * @param plateColor null if not use plateColor condition
   * @return
   */
  override def qryVehBrief(vehId: lang.Long, plateNo: String, plateColor: Integer): Array[VehBrief] = {
    checkReply(getParamsOpt[VehBrief](VehRepoApiImpl.VEH_BRIEF_PATH, VehRepoApiImpl.VEH_BRIEF_REPLY_TYPE,
      "vehId" -> Option(vehId),
      "plateNo" -> Option(plateNo),
      "plateColor" -> Option(plateColor)
    )).getData
  }

  override def qryVehBriefBySimNo(simNo: String): VehBrief = {
    if (simNo == null)
      throw ErrorWithCode.invalidParam("simNo")

    checkReply(get[VehBrief](VehRepoApiImpl.VEH_BRIEF_PATH, VehRepoApiImpl.VEH_BRIEF_REPLY_TYPE,
      "simNo" -> simNo
    )).firstOrNull()
  }

  override def cachedGetVehBrief(vehId: Long): VehBrief =
    checkReply(getParamsOpt[VehBrief](VehRepoApiImpl.VEH_BRIEF_PATH, VehRepoApiImpl.VEH_BRIEF_REPLY_TYPE,
      "vehId" -> Some(vehId)
    )).firstOrNull()

  override def getVehCurrDrv(plateNo: String, plateColor: Int): VehCurrDrv = {
    val briefs = qryVehBrief(null, plateNo, plateColor)
    if (briefs != null && briefs.length > 0) {
      val vehId = briefs(0).getVehId
      getVehCurrDrv(vehId)
    } else
      null
  }

  override def fetchVehBriefNeedsUploadToGov(fetchCount: Int): Array[VehBrief] =
    checkReply(get[VehBrief](VehRepoApiImpl.VEH_BRIEF_REG_TO_GOV_PATH, VehRepoApiImpl.VEH_BRIEF_REPLY_TYPE)).getData

  override def markVehBriefRegToGov(vehs: util.List[PlateNoAndColor]): Unit = {
    checkReply(post(VehRepoApiImpl.VEH_MARK_REG_TO_GOV_PATH, MarkVehRegToGovReq(vehs)))
  }


}

object VehRepoApiImpl {
  val VEH_BRIEF_PATH = "veh/brief"
  val VEH_BRIEF_REPLY_TYPE: Type = new TypeToken[Reply[VehBrief]]() {}.getType

  val VEH_BRIEF_REG_TO_GOV_PATH = "veh/brief/reg_to_gov"
  val VEH_MARK_REG_TO_GOV_PATH = "veh/reg_to_gov"

  case class MarkVehRegToGovReq(vehs: util.List[PlateNoAndColor])
}
