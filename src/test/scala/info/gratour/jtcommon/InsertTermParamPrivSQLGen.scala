/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jtcommon

import info.gratour.jt808core.JT808TermParams

object InsertTermParamPrivSQLGen {

  def main(args: Array[String]): Unit = {
    val read = JTMessages.get("termParamRead")
    val write = JTMessages.get("termParamWrite")

    JT808TermParams.SICHUAN.values.filter(p => {
      val id = Integer.parseInt(p.id, 16)
      (id < 0x112) || (id > 0x1FF)
    }).toList.sortWith((a, b) => a.id.compare(b.id) < 0)
      .foreach(p => {
        var sql = s"INSERT INTO t_priv (f_priv_code, f_priv_name) VALUES ('term_cmd:pr:${p.id}', '${read} ${p.name}');"
        println(sql)
        sql = s"INSERT INTO t_priv (f_priv_code, f_priv_name) VALUES ('term_cmd:pw:${p.id}', '${write} ${p.name}');"
        println(sql)
        println()
      })
  }
}
