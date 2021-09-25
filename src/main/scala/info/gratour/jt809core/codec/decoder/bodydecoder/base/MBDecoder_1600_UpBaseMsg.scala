package info.gratour.jt809core.codec.decoder.bodydecoder.base

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.base.{JT809Msg_1601_UpBaseMsgVehicleAddedAck, JT809UpBaseMsg}
import io.netty.buffer.ByteBuf

object MBDecoder_1600_UpBaseMsg extends VehRelatedMsgBodyDecoder {

  override def msgId: Int = JT809UpBaseMsg.MSG_ID

  override def decodeSubBody(msg: JT809VehRelatedMsg, buf: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1601_UpBaseMsgVehicleAddedAck =>
        m.setCarInfo(buf.readRemainingAsStr())
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_1601_UpBaseMsgVehicleAddedAck]
  )
}
