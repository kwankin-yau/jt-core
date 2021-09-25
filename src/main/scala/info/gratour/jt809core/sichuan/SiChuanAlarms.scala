package info.gratour.jt809core.sichuan

import info.gratour.jtcommon.{JTUtils, JTMessages}

object SiChuanAlarms {

  def isSiChuanAlarmType(alarmType: Int): Boolean = {
    alarmType match {
      case t if 0x0201 to 0x0208 contains t =>
        true

      case t if 0x0211 to 0x0219 contains t =>
        true

      case t if 0x0221 to 0x0227 contains t =>
        true

      case t if 0x0231 to 0x0234 contains t =>
        true

      case t if 0x0241 to 0x0247 contains t =>
        true

      case _ =>
        false
    }
  }

  def getAlarmTypeText(alarmType: Int): String = {
    val key = "ALARM_TYPE_" + JTUtils.intToHex(alarmType, 4)
    JTMessages.get(key)
  }

}
