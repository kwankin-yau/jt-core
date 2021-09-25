package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.EmptyMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9004_DownDisconnectRsp

object MBEncoder_9004_DownDisconnectRsp extends EmptyMsgBodyEncoder{
  override def msgId: Int = JT809Msg_9004_DownDisconnectRsp.MSG_ID
}
