package info.gratour.jt809core.codec.decoder.bodydecoder.base

import info.gratour.jt809core.codec.decoder.bodydecoder.VehRelatedMsgBodyDecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.base.{JT809DownBaseMsg, JT809Msg_9601_DownBaseMsgVehicleAdded}
import io.netty.buffer.ByteBuf

object MBDecoder_9600_DownBaseMsg extends VehRelatedMsgBodyDecoder {

  override def msgId: Int = JT809DownBaseMsg.MSG_ID

  override def decodeSubBody(msg: JT809VehRelatedMsg, subBody: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9601_DownBaseMsgVehicleAdded =>
        // do nothing
    }
  }

  override def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]] = Seq(
    classOf[JT809Msg_9601_DownBaseMsgVehicleAdded]
  )
}
