/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.adaptor.impl

import java.lang.reflect.Type

import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.GnssGrpRepo
import info.gratour.adaptor.types.RegToGovGrps
import info.gratour.common.types.rest.Reply

class GnssGrpRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends GnssGrpRepo with APIClient {

  override def qryRegToGovGrpsFull(): RegToGovGrps = {
    checkReply(get[RegToGovGrps](GnssGrpRepoApiImpl.REG_TO_GOV_PATH, GnssGrpRepoApiImpl.REG_TO_GOV_REPLY_TYPE, "full" -> true)).first()
  }

  //  override def setRegToGovGrps(grps: RegToGovGrps): RegToGovGrps = {
  //    checkReply(put[RegToGovGrps](GnssGrpRepoApiImpl.REG_TO_GOV_PATH, GnssGrpRepoApiImpl.REG_TO_GOV_REPLY_TYPE, grps)).first()
  //  }

}

object GnssGrpRepoApiImpl {
  val REG_TO_GOV_PATH = "grp/reg_to_gov"
  val REG_TO_GOV_REPLY_TYPE: Type = new TypeToken[Reply[RegToGovGrps]]() {}.getType
}
