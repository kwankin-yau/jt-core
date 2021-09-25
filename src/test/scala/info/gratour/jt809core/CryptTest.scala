/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt809core

import info.gratour.jt809core.types.{CryptParams, CryptSettings}
import io.netty.buffer.UnpooledByteBufAllocator

object CryptTest {

  def main(args: Array[String]): Unit = {
    val cp = new CryptParams()
    cp.setKey(1234567)
    cp.setSettings(new CryptSettings())
    cp.getSettings.setM(10000000)
    cp.getSettings.setIa(20000000)
    cp.getSettings.setIc(30000000)

    val alloc = UnpooledByteBufAllocator.DEFAULT
    val plain = alloc.buffer()
    val PlainText = "This is a test!"
    plain.writeBytes(PlainText.getBytes())

    val cipherText = alloc.buffer()
    cp.encrypt(plain, plain.readableBytes(), cipherText)

    plain.clear()
    cp.decrypt(cipherText, cipherText.readableBytes(), plain)
    val bytes = new Array[Byte](plain.readableBytes())
    plain.readBytes(bytes)
    val s = new String(bytes)

    println(s)
    assert(s.equals(PlainText))

  }
}
