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
import info.gratour.adaptor.GnssClient
import info.gratour.common.service.MemDbService
import info.gratour.common.types.rest.Reply
import okhttp3.Request

class GnssClientImpl(theEndPointUrl: String, memDb: MemDbService)
  extends GnssAdaptorApiImpl(theEndPointUrl, memDb) with GnssClient {

  val login = new APIClient {
    override def endPointUrl: String = theEndPointUrl

    override def authentication: APIAuthentication = (builder: Request.Builder) => builder
  }

  private val ReplyType: Type = new TypeToken[Reply[LoginResult]](){}.getType

  override def login(userName: String, password: String): Unit = {
    val req = LoginReq(userName, password)
    val reply = login.checkReply(login.post[LoginResult]("login", ReplyType, req))
    token = reply.getData()(0).authToken
  }

  def getToken: String = token
}

case class LoginReq(userName: String, password: String)
case class LoginResult(authToken: String)
