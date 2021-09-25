/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jtcommon

import com.google.gson.Gson
import info.gratour.common.error.Errors
import info.gratour.common.types.rest.RawReply
import okhttp3.Response

object OkHttpHelper {

  def responseToRawReply(response: Response, apiName: String, gson: Gson): RawReply = {
    if (response.isSuccessful) {
      val body = response.body()
      if (body != null) {
        try {
          val s = body.string()
          gson.fromJson(s, classOf[RawReply])
        } catch {
          case t: Throwable =>
            val msg = s"Error occurred when call $apiName: " + t.getLocalizedMessage + "."
            new RawReply(Errors.EXECUTION_ERROR, msg)
        }
      } else {
        val msg = s"Error occurred when call $apiName: The response has no body."
        new RawReply(Errors.EXECUTION_ERROR, msg)
      }
    } else {
      val msg = s"Error occurred when call $apiName: " + response.code() + "/" + response.message()
      new RawReply(Errors.EXECUTION_ERROR, msg)
    }
  }

  def responseToRawReply(response: Response, apiName: String): RawReply =
    responseToRawReply(response, apiName, JTConsts.GSON)

}
