package info.gratour.jt809core.types

trait GnssCenterRegistry {

  /**
   *
   * @param gnssCenterId
   * @return null if not found
   */
  def get(gnssCenterId: Int): GnssCenterSettings
}


