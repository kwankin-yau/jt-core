package info.gratour.jt809core.types

import io.netty.util.NetUtil

trait GnssCenterSettings {
  def gnssAreaCode: String
  def gnssCenterId: Int
  def platformId: String = gnssAreaCode + gnssCenterId

  def accountInfo: AccountInfo
  def encrypt: Boolean
  def cryptSettings: CryptSettings

  def isValidDownLinkIp(downLinkIp: String): Boolean
  def isValidDownLinkPort(downLinkPort: Int): Boolean
}

case class SimpleGnssCenterSettings(gnssAreaCode: String, gnssCenterId: Int, accountInfo: AccountInfo, encrypt: Boolean, cryptSettings: CryptSettings) extends GnssCenterSettings {

  override def isValidDownLinkIp(downLinkIp: String): Boolean =
    NetUtil.isValidIpV4Address(downLinkIp) || NetUtil.isValidIpV6Address(downLinkIp)

  override def isValidDownLinkPort(downLinkPort: Int): Boolean =
    downLinkPort > 0 && downLinkPort < 65536
}
