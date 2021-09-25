package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.EmptyMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1004_UpDisconnectRsp

object MBEncoder_1004_UpDisconnectRsp extends EmptyMsgBodyEncoder{
  override def msgId: Int = JT809Msg_1004_UpDisconnectRsp.MSG_ID
}
