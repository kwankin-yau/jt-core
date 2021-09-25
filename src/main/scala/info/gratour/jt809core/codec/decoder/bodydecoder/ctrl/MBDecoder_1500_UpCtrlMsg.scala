package info.gratour.jt809core.codec.decoder.bodydecoder.ctrl

import info.gratour.common.Consts
import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.ctrl._
import io.netty.buffer.ByteBuf

object MBDecoder_1500_UpCtrlMsg extends VehRelatedMsgBodyDecoder {

  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1501_UpCtrlMsgMonitorVehicleAck =>
        m.setResult(buf.readByte())

      case m: JT809Msg_1502_UpCtrlMsgTakePhotoAck =>
        if (m.getPhotoRspFlag == 1) {
          m.setGnssData(decodeGnssData(buf))
          m.setLensId(buf.readByte())
          val photoSize = buf.readInt()
          m.setSizeType(buf.readByte())
          m.setFormat(buf.readByte())
          if (photoSize > 0) {
            val photo = new Array[Byte](photoSize)
            buf.readBytes(photo)
            m.setPhotoBinary(photo)
          } else
            m.setPhotoBinary(Consts.EMPTY_BYTE_ARRAY)
        }


      case m: JT809Msg_1503_UpCtrlMsgTextInfoAck =>
        m.setReqMsgId(buf.readInt())
        m.setResult(buf.readByte())


      case m: JT809Msg_1504_UpCtrlMsgTakeTravelAck =>
        m.setCommandType(buf.readByte())
        m.setTravelDataInfo(buf.readIntLenPrefixedStr())


      case m: JT809Msg_1505_UpCtrlMsgEmergencyMonitoringAck =>
        m.setResult(buf.readByte())
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_1501_UpCtrlMsgMonitorVehicleAck],
    classOf[JT809Msg_1502_UpCtrlMsgTakePhotoAck],
    classOf[JT809Msg_1503_UpCtrlMsgTextInfoAck],
    classOf[JT809Msg_1504_UpCtrlMsgTakeTravelAck],
    classOf[JT809Msg_1505_UpCtrlMsgEmergencyMonitoringAck]
  )

  override def msgId: Int = JT809UpCtrlMsg.MSG_ID
}
