package info.gratour.jt809core.codec.encoder.bodyencoder.link

import info.gratour.jt809core.codec.encoder.bodyencoder.EmptyMsgBodyEncoder
import info.gratour.jt809core.protocol.msg.link.JT809Msg_9006_DownLinkTestRsp

object MBEncoder_9006_DownLinkTestRsp extends EmptyMsgBodyEncoder{
  override def msgId: Int = JT809Msg_9006_DownLinkTestRsp.MSG_ID
}
