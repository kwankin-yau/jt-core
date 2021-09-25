package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.EmptyMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_1006_UpLinkTestRsp

object MBEncoder_1006_UpLinkTestRsp extends EmptyMsgBodyEncoder{
  override def msgId: Int = JT809Msg_1006_UpLinkTestRsp.MSG_ID
}
