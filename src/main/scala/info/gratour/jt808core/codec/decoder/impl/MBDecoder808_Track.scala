/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.codec.decoder.impl

import java.util

import com.typesafe.scalalogging.Logger
import info.gratour.common.utils.StringUtils
import info.gratour.jt808core.JT808Utils
import info.gratour.jt808core.protocol.JT808Msg
import info.gratour.jtcommon.JTCodecHelper
import info.gratour.jtmodel.trk._
import io.netty.buffer.ByteBuf

private class MBDecoder808_Track
object MBDecoder808_Track extends JTCodecHelper {

  private val logger = Logger[MBDecoder808_Track]

  private def readSiChuanAlarmIdentity(buf: ByteBuf, tempBuf: Array[Byte]): String = {
    buf.readBytes(tempBuf, 0, 16)
    StringUtils.hex(tempBuf, 0, 16)
  }


  def decodeTrack(m: JT808Msg, buf: ByteBuf, tempBuf: Array[Byte], recvTime: Long, retransmit: Boolean): Trk = {
    val t = new Trk
    t.setSimNo(m.getSimNo)
    //    t.setMsgSeqNo(m.getSeqNo)
    t.setRecvTm(recvTime)
    if (retransmit)
      t.setRetrans(true)

    t.setAlm(buf.readInt())
    t.setSt(buf.readInt())
    t.setLat(buf.readAxis())
    t.setLng(buf.readAxis())
    t.setAlt(buf.readShort())
    t.setSpd(buf.readShort() / 10)
    t.setDir(buf.readShort())
    buf.readBytes(tempBuf, 0, 6)
    t.setGpsTm(JT808Utils.bcd6ToTimestamp(tempBuf))

    var _addt: TrkAddt = null

    def addt: TrkAddt = {
      if (_addt == null) {
        _addt = new TrkAddt
        t.setAddt(_addt)
      }

      _addt
    }

    while (buf.readableBytes() >= 2) {
      val infoId = buf.readUnsignedByte()
      val len = buf.readUnsignedByte()
      val readerIndex = buf.readerIndex()

//      logger.debug("infoId: " + StringUtils.intToHex(infoId, 2))
//      logger.debug("len: " + len)

      infoId match {
        case 0x01 =>
          val mile = buf.readInt() / 10f
          t.setMile(mile)

        case 0x02 =>
          val gas = buf.readShort() / 10f
          t.setGas(gas)

        case 0x03 =>
          val spd = buf.readShort() / 10f
          t.setRecSpd(spd)

        case 0x04 =>
          addt.setConfirmAlmId(buf.readUnsignedShort())

        case 0x11 =>
          val info = new OverSpdAddt
          info.setTyp(buf.readByte())
          if (info.getTyp != 0 && len > 1)
            info.setAreaId(buf.readInt())
          addt.setOverSpd(info)

        case 0x12 =>
          val info = new AcrossAreaAddt
          info.setTyp(buf.readByte())
          info.setAreaId(buf.readInt())
          info.setDir(buf.readByte())
          addt.setAcrossArea(info)

        case 0x13 =>
          val info = new RouteAlmAddt
          info.setRouteId(buf.readInt())
          info.setTm(buf.readUnsignedShort())
          info.setTyp(buf.readByte())
          addt.setRouteAlm(info)

        case 0x25 =>
          t.setSignal(buf.readInt())

        case 0x2A =>
          t.setIoSt(buf.readShort())

        case 0x2B =>
          val qty = new AnalogQty
          qty.setAd0(buf.readUnsignedShort())
          qty.setAd1(buf.readUnsignedShort())
          addt.setAnQty(qty)

        case 0x30 =>
          addt.setNetSigStr(buf.readByte().toShort)

        case 0x31 =>
          addt.setSat(buf.readByte().toShort)

        // 1078
        case 0x14 =>
          t.setVidAlm(buf.readInt())

        case 0x15 =>
          addt.setVidLoss(buf.readInt())

        case 0x16 =>
          addt.setVidCover(buf.readInt())

        case 0x17 =>
          addt.setVidStgAlm(buf.readShort())

        case 0x18 =>
          val typ = buf.readShort()
          if (len > 2) {
            val lvl = buf.readByte()
            if (typ != 0) {
              val info = new UnusualDriveBehav
              info.setTyp(typ)
              info.setTiredLvl(lvl)
              t.setUnusualDriveBehav(info)
            }
          }

        // si-chuan / ADAS
        case 0x64 =>
          val alarm = new AdasDrivingAssistAlmAddt
          alarm.setAlmId(buf.readInt())
          alarm.setFlag(buf.readByte())
          alarm.setTyp(buf.readByte())
          alarm.setLvl(buf.readByte())
          alarm.setFrontCarSpd(buf.readUnsignedByte())
          alarm.setFrontCarDist(buf.readUnsignedByte() * 0.1f)
          alarm.setDeviateTyp(buf.readByte())
          alarm.setRdRecogMark(buf.readByte())
          alarm.setRdRecogDat(buf.readByte())
          alarm.setSpd(buf.readByte())
          alarm.setAlt(buf.readShort())
          alarm.setLat(buf.readAxis())
          alarm.setLng(buf.readAxis())
          buf.readBytes(tempBuf, 0, 6)
          alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
          alarm.setVehSt(buf.readShort())
          alarm.setAlmNo(readSiChuanAlarmIdentity(buf, tempBuf))

          t.setDrivingAssistAlm(alarm)

        case 0x65 =>
          val alarm = new AdasDriverBehavAlmAddt
          alarm.setAlmId(buf.readInt())
          alarm.setFlag(buf.readByte())
          alarm.setTyp(buf.readByte())
          alarm.setLvl(buf.readByte())
          alarm.setFatigue(buf.readByte())
          buf.skipBytes(4)
          alarm.setSpd(buf.readUnsignedByte())
          alarm.setAlt(buf.readShort())
          alarm.setLat(buf.readAxis())
          alarm.setLng(buf.readAxis())
          buf.readBytes(tempBuf, 0, 6)
          alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
          alarm.setVehSt(buf.readShort())
          alarm.setAlmNo(readSiChuanAlarmIdentity(buf, tempBuf))

          t.setDriverBehavAlm(alarm)

        case 0x66 =>
          val alarm = new AdasTyreState
          alarm.setAlmId(buf.readInt())
          alarm.setFlag(buf.readByte())
          alarm.setSpd(buf.readUnsignedByte())
          alarm.setAlt(buf.readShort())
          alarm.setLat(buf.readAxis())
          alarm.setLng(buf.readAxis())
          buf.readBytes(tempBuf, 0, 6)
          alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
          alarm.setVehSt(buf.readShort())
          alarm.setAlmNo(readSiChuanAlarmIdentity(buf, tempBuf))
          val list = new util.ArrayList[PressureAlarmInfo]()
          alarm.setPressureAlarmInfoList(list)
          val cnt = buf.readUnsignedByte()
          for (_ <- 1 to cnt) {
            val info = new PressureAlarmInfo
            info.setTyreNo(buf.readByte())
            info.setTyp(buf.readShort())
            info.setPress(buf.readUnsignedShort())
            info.setTemp(buf.readUnsignedShort())
            info.setBatt(buf.readShort())

            list.add(info)
          }
          alarm.setPressureAlarmInfoList(list)

          t.setAdasTyreState(alarm)

        case 0x67 =>
          val alarm = new AdasBlindAreaAlmAddt
          alarm.setAlmId(buf.readInt())
          alarm.setFlag(buf.readByte())
          alarm.setTyp(buf.readByte())
          alarm.setSpd(buf.readUnsignedByte())
          alarm.setAlt(buf.readShort())
          alarm.setLat(buf.readAxis())
          alarm.setLng(buf.readAxis())
          buf.readBytes(tempBuf, 0, 6)
          alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
          alarm.setVehSt(buf.readShort())
          alarm.setAlmNo(readSiChuanAlarmIdentity(buf, tempBuf))

          t.setAdasBlindAreaAlarm(alarm)

        case 0x70 =>
          val alarm = new AdasIntenseDrivingAlmAddt
          alarm.setAlmId(buf.readInt())
          alarm.setFlag(buf.readByte())
          alarm.setTyp(buf.readByte())
          alarm.setDur(buf.readShort())
          alarm.setThold1(buf.readShort())
          alarm.setThold2(buf.readShort())

          alarm.setSpd(buf.readUnsignedByte())
          alarm.setAlt(buf.readShort())
          alarm.setLat(buf.readAxis())
          alarm.setLng(buf.readAxis())
          buf.readBytes(tempBuf, 0, 6)
          alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
          alarm.setVehSt(buf.readShort())
          alarm.setAlmNo(readSiChuanAlarmIdentity(buf, tempBuf))

          t.setAdasIntenseDrivingAlarm(alarm)

        case 0x71 =>
          if (len >= 44) {
            val alarm = new AdasOverSpdAlmAddt
            alarm.setAlmId(buf.readInt()) // 4
            alarm.setFlag(buf.readByte()) // 1
            alarm.setTyp(buf.readByte()) // 1
            alarm.setOverSpdAlmTyp(buf.readByte()) // 1
            alarm.setTermSpdThold(buf.readUnsignedByte()) // 1
            alarm.setRdSpdThold(buf.readUnsignedByte()) // 1

            alarm.setSpd(buf.readUnsignedByte()) // 1
            alarm.setAlt(buf.readShort()) // 2
            alarm.setLat(buf.readAxis()) // 4
            alarm.setLng(buf.readAxis()) // 4
            buf.readBytes(tempBuf, 0, 6) // 6
            alarm.setTm(JT808Utils.bcd6ToTimestamp(tempBuf, 0))
            alarm.setVehSt(buf.readShort()) // 2
            alarm.setAlmNo(readSiChuanAlarmIdentity(buf, tempBuf)) // 16

            t.setAdasOverSpdAlarm(alarm)
          }

        case _ =>
      }

      val delta = len - (buf.readerIndex() - readerIndex)
      if (delta > 0) {
//        logger.debug(s"skip $delta bytes")
        buf.skipBytes(delta)
      }
    }

    t
  }
}
