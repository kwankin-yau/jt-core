/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808core

object JT808StateNameTest {

  def main(args: Array[String]): Unit = {
    val st = 786434
    val text = JT808StateBit.vehStateText(st)
    println(text)
  }
}
