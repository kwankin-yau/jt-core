package info.gratour.jt809core.codec.encoder.bodyencoder.base

import info.gratour.jt809core.codec.encoder.bodyencoder.VehRelatedMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.msg.base.{JT809DownBaseMsg, JT809Msg_9601_DownBaseMsgVehicleAdded}
import io.netty.buffer.ByteBuf

object MBEncoder_9600_DownBaseMsg extends VehRelatedMsgBodyEncoder {

  override def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit = {
    msg match {
      case m: JT809Msg_9601_DownBaseMsgVehicleAdded =>
        // nop
    }
  }

  override def msgId: Int = JT809DownBaseMsg.MSG_ID
}
