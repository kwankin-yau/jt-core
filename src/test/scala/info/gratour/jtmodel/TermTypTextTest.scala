/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtmodel

object TermTypTextTest {

  def main(args: Array[String]): Unit = {
    println(Term.typText(Term.TERM_TYPE__2G))
    println(Term.typText(6))
  }
}
