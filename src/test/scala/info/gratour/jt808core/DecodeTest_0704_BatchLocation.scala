/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core

import org.junit.Test

class DecodeTest_0704_BatchLocation extends JT808DecodeTest {
  val hexPacketData: String = "7e070400a90133202003170001000201005100000000000002010000000000000000000000000000200317170233010400000000020200000302000030010031010025040000000014040000000515040000000e160400000000170200071803000000005100000000000002010000000000000000000000000000200317170234010400000000020200000302000030010031010025040000000014040000000515040000000e1604000000001702000518030000008b7e"

  @Test
  def test(): Unit = {
    doTest(hexPacketData)
  }
}

object DecodeTest_0704_BatchLocation {
  def main(args: Array[String]): Unit = {
    val t = new DecodeTest_0704_BatchLocation
    t.test()
  }
}
