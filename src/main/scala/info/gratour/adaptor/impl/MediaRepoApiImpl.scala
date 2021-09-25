package info.gratour.adaptor.impl


import java.lang.reflect.Type

import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.MediaRepo
import info.gratour.adaptor.types.CreateMMReq
import info.gratour.common.types.rest.Reply
import info.gratour.jtmodel.MultiMedia

class MediaRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends MediaRepo with APIClient {
  override def createMedia(req: CreateMMReq): MultiMedia = {
    checkReply(post[MultiMedia](MediaRepoApiImpl.MULTI_MEDIA_PATH, MediaRepoApiImpl.MULTI_MEDIA_REPLY_TYPE, req)).firstOrNull()
  }
}

object MediaRepoApiImpl {
  val MULTI_MEDIA_PATH = "mm"
  val MULTI_MEDIA_REPLY_TYPE: Type = new TypeToken[Reply[MultiMedia]](){}.getType
}
