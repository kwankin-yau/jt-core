/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.impl

import com.typesafe.scalalogging.Logger
import info.gratour.adaptor.SysRepo
import info.gratour.common.utils.NetUtils
import info.gratour.jtmodel.SysParam

case class GnssLinkSysRepoHelper(sysRepo: SysRepo) {

  import GnssLinkSysRepoHelper.logger

  def get(paramName: String): String =
    sysRepo.getSysParam(SysParam.SCOPE_GNSS_LINK, paramName)


  /**
   *
   * @param paramName
   * @return 0 for not found
   */
  def getPort(paramName: String): Int = {
    val r = sysRepo.getSysParamAsInt(SysParam.SCOPE_GNSS_LINK, paramName, 0)
    if (r <= 0 || r > 65535) {
      logger.warn(s"System parameter: `${SysParam.SCOPE_GNSS_LINK}/${paramName}` is not defined or invalid.")

      0
    } else
      r
  }


  /**
   *
   * @param paramName
   * @return null if can not resolve
   */
  def getAndResolveHost(paramName: String): String = {
    val host = get(paramName)
    if (host != null) {
      if (!NetUtils.isValidIp(host)) {
        val dns = sysRepo.getSysParam(SysParam.SCOPE_GNSS_LINK, SysParam.DNS_SERVER)
        logger.whenDebugEnabled {
          logger.debug(s"lookup name: $host using server: $dns")
        }

        var ip: String = null
        try {
          ip = NetUtils.resolvePublicIp(host, dns).getHostAddress
        } catch {
          case t: Throwable =>
            logger.error(s"Can not resolve host: `${host}`.", t)
            return null
        }
        logger.whenDebugEnabled {
          logger.debug(s"host: $host resolved to $ip")
        }

        ip
      } else
        host
    } else
      null
  }

//  def rtmpServerHost: String = getAndResolveHost(SysParam.RTMP_SERVER_HOST)
//  def rtmpServicePort: Int = getPort(SysParam.RTMP_SERVICE_PORT)
//  def rtmpAppName: String = get(SysParam.RTMP_APP_NAME)
//
//  def flvServerHost: String = getAndResolveHost(SysParam.FLV_SERVER_HOST)
//  def flvServicePort: Int = getPort(SysParam.FLV_SERVICE_PORT)
//  def flvAppName: String = get(SysParam.FLV_APP_NAME)
}

object GnssLinkSysRepoHelper {
  private val logger = Logger[GnssLinkSysRepoHelper]
}
