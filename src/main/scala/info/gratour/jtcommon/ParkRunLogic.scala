/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtcommon

import info.gratour.common.CommonMessages


trait TravelType {
  def typ: Short
  def isRun: Boolean
  def isPark: Boolean = !isRun
}
object TravelType {
  val TYP__RUN: Short = 1
  val TYP__PARK: Short = 2

  val MESSAGE_KEY_TYP__RUN = "travelTyp.run"
  val MESSAGE_KEY_TYP__PARK = "travelTyp.park"

  def toText(typ: Short): String = typ match {
    case TYP__RUN =>
      JTMessages.get(MESSAGE_KEY_TYP__RUN)

    case TYP__PARK =>
      JTMessages.get(MESSAGE_KEY_TYP__PARK)

    case _ =>
      CommonMessages.UNKNOWN
  }
}

case object TravelType_Run extends TravelType {
  override def typ: Short = TravelType.TYP__RUN

  override def isRun: Boolean = true

}
case object TravelType_Park extends TravelType {
  override def typ: Short = TravelType.TYP__PARK

  override def isRun: Boolean = false
}

trait ParkRunLogic {

  def test(accOn: Boolean, spd: Float): TravelType
}

object DefaultParkRunLogic extends ParkRunLogic {

  override def test(accOn: Boolean, spd: Float): TravelType = {
    if (accOn && spd > 0)
      TravelType_Run
    else
      TravelType_Park
  }
}
