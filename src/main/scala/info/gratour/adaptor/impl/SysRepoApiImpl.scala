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
import info.gratour.adaptor.SysRepo
import info.gratour.common.types.rest.Reply
import info.gratour.common.utils.StringUtils
import info.gratour.jtmodel.{SeqValue, SysParam}

class SysRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends SysRepo with APIClient {

  val sysParamLoadingCache = new SysParamLoadingCache(new SysParamLoadingCache.Loader {
    override def load(scope: String, name: String): SysParam =
      checkReply(get[SysParam](SysRepoApiImpl.SYS_PARAM_PATH, SysRepoApiImpl.SYS_PARAM_REPLY_TYPE, "scope" -> scope, "name" -> name)).firstOrNull()
  })

  override def nextSeqValue(seqName: String): Long = {
    val r = checkReply(get[SeqValue]("seq", SysRepoApiImpl.SeqValueReplyType, "seqName" -> seqName))
    if (r.hasData)
      r.firstOrNull().getNextVal
    else
      -1
  }

  override def getSysParam(scope: String, name: String): String =
    sysParamLoadingCache.get(scope, name)

  override def invalidCache(): Unit = {
    sysParamLoadingCache.invalidateAll();
  }
}

object SysRepoApiImpl {
  val SYS_PARAM_PATH = "sysparam"
  val SYS_PARAM_REPLY_TYPE: Type = new TypeToken[Reply[SysParam]](){}.getType
  val SeqValueReplyType: Type = new TypeToken[Reply[SeqValue]](){}.getType
}

