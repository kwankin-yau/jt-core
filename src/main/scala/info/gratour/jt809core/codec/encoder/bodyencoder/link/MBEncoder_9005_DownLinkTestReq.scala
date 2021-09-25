package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.EmptyMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9005_DownLinkTestReq

object MBEncoder_9005_DownLinkTestReq extends EmptyMsgBodyEncoder{
  override def msgId: Int = JT809Msg_9005_DownLinkTestReq.MSG_ID
}
