package info.gratour.adaptor.impl


import com.typesafe.scalalogging.Logger
import info.gratour.adaptor.{AVResRepo, AlmRepo, GnssAdaptor, GovIssueRepo, GnssGrpRepo, MediaRepo, RtRgnRepo, StrmMediaRepo, SysRepo, TermCmdRepo, TermRepo, VehRepo}
import info.gratour.common.service.MemDbService
import okhttp3.Request

class GnssAdaptorApiImpl(theEndPointUrl: String, memDb: MemDbService) extends GnssAdaptor {
  val endPointUrl: String = {
    if (theEndPointUrl.endsWith("/"))
      theEndPointUrl.substring(0, theEndPointUrl.length-1)
    else
      theEndPointUrl
  }

  GnssAdaptorApiImpl.logger.whenDebugEnabled {
    GnssAdaptorApiImpl.logger.debug(s"End point url: `$endPointUrl`.")
  }

  protected var token: String = "1f77553a-5c73-11ea-bc55-0242ac130003"

  protected val authentication: APIAuthentication = (builder: Request.Builder) => {
    builder.addHeader("X-Auth-Token", token)
  }

  override val sysRepo: SysRepo = new SysRepoApiImpl(endPointUrl, authentication)
  override val grpRepo: GnssGrpRepo = new GnssGrpRepoApiImpl(endPointUrl, authentication)
  override val termRepo: TermRepo = new TermRepoApiImpl(endPointUrl, authentication)
  override val termCmdRepo: TermCmdRepo = new TermCmdRepoApiImpl(endPointUrl, authentication)
  override val mediaRepo: MediaRepo = new MediaRepoApiImpl(endPointUrl, authentication)
  override val almRepo: AlmRepo = new AlmRepoApiImpl(endPointUrl, authentication)
  override val vehRepo: VehRepo = new VehRepoApiImpl(endPointUrl, authentication, memDb)
  override val avResRepo: AVResRepo = new AVResRepoApiImpl(endPointUrl, authentication)
  override val govIssueRepo: GovIssueRepo = new GovIssueRepoApiImpl(endPointUrl, authentication)
  override val rtRgnRepo: RtRgnRepo = new RtRgnApiImpl(endPointUrl, authentication)
  override val strmMediaRepo: StrmMediaRepo = new StrmMediaRepoApiImpl(endPointUrl, authentication)

}

object GnssAdaptorApiImpl {
  private val logger = Logger[GnssAdaptorApiImpl]
}
