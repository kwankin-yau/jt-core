/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.impl

import java.lang.reflect.Type

import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.GovIssueRepo
import info.gratour.adaptor.types.MarkInspectAckSentReq
import info.gratour.common.types.rest.Reply
import info.gratour.jtmodel.govissue.{AlmSupervise, GovInspect}

class GovIssueRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends GovIssueRepo with APIClient {

  override def createGovInspect(req: GovInspect): Unit =
    checkReply(post(GovIssueRepoApiImpl.GOV_INSPECT_PATH, req))

  /**
   *
   * @param req
   * @return the AlmSupervise with tm property, note: the grpName does not filled
   */
  override def createAlmSupervise(req: AlmSupervise): AlmSupervise = {
    checkReply(post[AlmSupervise](GovIssueRepoApiImpl.ALM_SUPERVISE_PATH, GovIssueRepoApiImpl.ALM_SUPERVISE_REPLY_TYPE, req)).firstOrNull()
  }

  override def markGovInspectAckSent(req: MarkInspectAckSentReq): Unit = {
    checkReply(put(GovIssueRepoApiImpl.GOV_INSPECT_ACK_SENT_PATH, req))
  }
}

object GovIssueRepoApiImpl {

  val GOV_INSPECT_PATH = "gov_inspect"
  //  val GOV_INSPECT_ACK_PATH= "gov_inspect/ack"

  //  val GOV_INSPECT_REPLY_TYPE: Type = new TypeToken[Reply[GovInspect]](){}.getType

  val GOV_INSPECT_ACK_SENT_PATH = "gov_inspect/ack_sent"

  val ALM_SUPERVISE_PATH = "alm_supervise"
  val ALM_SUPERVISE_REPLY_TYPE: Type = new TypeToken[Reply[AlmSupervise]]() {}.getType
}
