/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808core.protocol

import java.util.{Locale, MissingResourceException, ResourceBundle}

import info.gratour.jtcommon.JTUtils

trait MsgNameResolver {

  def nameOf(msgId: Int): String

  def nameOf(msgId: String): String = nameOf(Integer.parseInt(msgId, 16))
}

object DefaultMsgNameResolver extends MsgNameResolver {

  private val JT808_MSG_NAMES_BUNDLE: ResourceBundle = ResourceBundle.getBundle("info.gratour.jt808core.protocol.jt808-msg-names", Locale.getDefault)
  private val JT1078_MSG_NAMES_BUNDLE: ResourceBundle = ResourceBundle.getBundle("info.gratour.jt808core.protocol.jt1078-msg-names", Locale.getDefault)

  override def nameOf(msgId: Int): String = {
    val key = JTUtils.msgIdToHex(msgId)
    try {
      if ((msgId & 0x9000) == 0x9000)
        JT1078_MSG_NAMES_BUNDLE.getString(key)
      else
        JT808_MSG_NAMES_BUNDLE.getString(key)
    } catch {
      case _: MissingResourceException =>
        "Unknown (" + key + ")"
    }
  }

}
