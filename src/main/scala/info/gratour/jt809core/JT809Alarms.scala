/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt809core

object JT809Alarms {

  val OVER_SPD = 0x0001
  val FATIGUED = 0x0002
  val PANIC = 0x0003
  val ENTER_REGION = 0x0004
  val LEAVE_REGION = 0x0005
  val OUT_OF_BOUNDS = 0x0008
  val STEAL = 0x0009
  val ROB = 0x000A
  val STRAY_PATH = 0x000B

  def isRev2013Alm(almType: Int): Boolean =
    (almType >= 0x0001 && almType <= 0x000D) || (almType == 0x00FF)

  def isRev2019Alm(almType: Int): Boolean =
    isRev2013Alm(almType) || (almType match {
      case x if x >= 0xA001 && x <= 0xA00C =>
        true

      case 0xA0FF =>
        true

      case _ =>
        false
    })

  def isSiChuanAlm(almType: Int): Boolean = almType match {
    case x if x >= 0x0001 && x <= 0x000D =>
      true

    case x if x >= 0x0010 && x <= 0x0014 =>
      true

    case 0x00FF =>
      true

    case x if x >= 0x0101 && x <= 0x0107 =>
      true

    case x if x >= 0x0201 && x <= 0x0208 =>
      true

    case x if x >= 0x0211 && x <= 0x0219 =>
      true

    case x if x >= 0x0221 && x <= 0x0227 =>
      true

    case x if x >= 0x0231 && x <= 0x0234 =>
      true

    case x if x >= 0x0241 && x <= 0x0247 =>
      true

    case x if x >= 0x0301 && x <= 0x0308 =>
      true

    case x if x >= 0x0311 && x <= 0x0314 =>
      true

    case x if x >= 0xA001 && x <= 0xA00C =>
      true

    case 0xA0FF =>
      true

    case _ =>
      false
  }


}
