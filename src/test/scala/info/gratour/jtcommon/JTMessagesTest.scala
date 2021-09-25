/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtcommon

object JTMessagesTest {

  def main(args: Array[String]): Unit = {
    val s = JTMessages.PlateColors.toText(JTMessages.PlateColors.BLACK)
    println(s)
  }


}
