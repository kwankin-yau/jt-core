/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core

import java.time.Instant

import info.gratour.common.Consts
import org.junit.{Assert, Test}

class JT808UtilsTest {

  @Test
  def testMakeTrkId(): Unit = {
    val rawTrkId = -1
    val instant = Instant.now()
    val localDate = instant.atOffset(Consts.ZONE_OFFSET_BEIJING).toLocalDate
    val epochDay = localDate.toEpochDay
    println(s"epochDay=$epochDay")
//    val id = JT808Utils.encodeTrkId(rawTrkId, instant.toEpochMilli)
//    println(s"id=$id")
//    val decodedEpochDay = JT808Utils.decodeEpochDayOfTrk(id)
//    println(s"decoed epochDay=$decodedEpochDay")
//    val date = JT808Utils.decodeDateOfTrk(id)
//    println(s"decoded date=$date")

    //    Assert
//    Assert.assertEquals(epochDay, decodedEpochDay)
  }
}
