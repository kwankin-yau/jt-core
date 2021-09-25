package info.gratour.jt809core.codec.encoder.bodyencoder.base

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.base.{JT809Msg_1601_UpBaseMsgVehicleAddedAck, JT809UpBaseMsg}
import io.netty.buffer.ByteBuf

object MBEncoder_1600_UpBaseMsg extends VehRelatedMsgBodyEncoder {

  override def msgId: Int = JT809UpBaseMsg.MSG_ID

  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_1601_UpBaseMsgVehicleAddedAck =>
        out.writeStr(m.getCarInfo)

    }

  }
}
