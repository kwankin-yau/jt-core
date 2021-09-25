package info.gratour.adaptor.impl


import java.lang.reflect.Type
import java.util.Objects

import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.TermRepo
import info.gratour.adaptor.TermRepo.{TermRegResult, TermUnregResult}
import info.gratour.adaptor.impl.TermBriefCache.TermBriefLoader
import info.gratour.common.error.Errors
import info.gratour.common.types.rest.Reply
import info.gratour.jtmodel.term.UpdateTermAVAttrsReq
import info.gratour.jtmodel.{Term, TermBrief, Veh}


class TermRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends TermRepo with APIClient {


  private def veh(plateNo: String, plateColor: Int): Veh = {
    val vr: Reply[Veh] = checkReply(get("veh", TermRepoApiImpl.VEHICLE_MULTI_REPLY_TYPE, "plateNo" -> plateNo, "plateColor" -> Integer.valueOf(plateColor)))
    if (vr.hasData)
      vr.getData()(0)
    else
      null
  }

  private def term(simNo: String): Term = {
    val tr: Reply[Term] = checkReply(get("term", TermRepoApiImpl.TERMINAL_MULTI_REPLY_TYPE, "simNo" -> simNo))
    if (tr.hasData)
      tr.getData()(0)
    else
      null
  }

  override def termRegister(simNo: String, plateNo: String, plateColor: Int, authCode: String): TermRegResult = {
    val t = term(simNo)
    val r = if (t == null)
      TermRepo.TermRegResult.TERM_NOT_FOUND
    else {
      if (t.getPlateNo == null || t.getPlateColor == null) {
        val v = veh(plateNo, plateColor)
        if (v == null)
          TermRepo.TermRegResult.VEH_NOT_FOUND
        else
          TermRepo.TermRegResult.VEH_REGISTERED
      } else {
        if (!Objects.equals(t.getPlateNo, plateNo) || t.getPlateColor == null || t.getPlateColor != plateColor)
          TermRepo.TermRegResult.TERM_REGISTERED
        else {
          val v = veh(plateNo, plateColor)
          if (!Objects.equals(v.getPlateNo, plateNo) || v.getPlateColor != plateColor)
            TermRepo.TermRegResult.VEH_REGISTERED
          else
            TermRepo.TermRegResult.OK
        }
      }
    }

    if (r.isOk) {
      checkReply(post("term/authCode", TermRepoApiImpl.UpdateTerminalAuthCodeReq(simNo, authCode)))
    }

    r
  }

  override def termUnregister(simNo: String): TermUnregResult = {
    val r = post("term/authCode", TermRepoApiImpl.UpdateTerminalAuthCodeReq(simNo, null))
    if (r.ok())
      TermRepo.TermUnregResult.OK
    else
      TermRepo.TermUnregResult.TERM_NOT_FOUND
  }

  override def qryTermAuthCode(simNo: String): String = {
    val t = qryTermBrief(simNo)
    if (t == null)
      null
    else
      t.getAuthCode
  }

  private def dbQryTermBrief(simNo: String): TermBrief =
    checkReply(get[TermBrief]("term/brief", TermRepoApiImpl.TERM_BRIEF_REPLY_TYPE, "simNo" -> simNo)).firstOrNull()

  private val dbLoader = new TermBriefLoader {
    override def load(simNo: String): TermBrief = dbQryTermBrief(simNo)
  }

  private val termBrief = new TermBriefCache(dbLoader)

  /**
   *
   * @param simNo
   * @return
   */
  override def qryTermBrief(simNo: String): TermBrief =
    termBrief.get(simNo)

  override def updateTermAVAttrs(req: UpdateTermAVAttrsReq): Boolean = {
    val r = put(TermRepoApiImpl.TERM_AV_ATTRS_PATH, req)
    if (r.getErrCode == Errors.RECORD_NOT_FOUND)
      false
    else
      checkReply(r).ok()
  }
}

object TermRepoApiImpl {
  val VEHICLE_MULTI_REPLY_TYPE: Type = new TypeToken[Reply[Veh]](){}.getType
  val TERMINAL_MULTI_REPLY_TYPE: Type = new TypeToken[Reply[Term]](){}.getType
  val TERM_BRIEF_REPLY_TYPE: Type = new TypeToken[Reply[TermBrief]](){}.getType

  val TERM_AV_ATTRS_PATH = "term/av_attrs"

  case class UpdateTerminalAuthCodeReq(simNo: String, authCode: String)
}
