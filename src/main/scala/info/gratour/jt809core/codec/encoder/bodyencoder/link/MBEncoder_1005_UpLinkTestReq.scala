package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.EmptyMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1005_UpLinkTestReq

object MBEncoder_1005_UpLinkTestReq extends EmptyMsgBodyEncoder{
  override def msgId: Int = JT809Msg_1005_UpLinkTestReq.MSG_ID
}
