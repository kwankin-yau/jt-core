package info.gratour.jt809core

import info.gratour.jt809core.types._

object GnssCenterRegistryTestImpl extends GnssCenterRegistry {
  private val registry = Seq(
    8992 -> SimpleGnssCenterSettings(8992, new DefaultAccountInfo(8992, "12345678"), new CryptSettings(10000000, 20000000, 30000000))
  ).toMap

  /**
   *
   * @param gnssCenterId
   * @return null if not found
   */
  override def get(gnssCenterId: Int): GnssCenterSettings = registry.get(gnssCenterId).orNull
}
