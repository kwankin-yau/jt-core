package info.gratour.jt809core.codec.encoder.bodyencoder

import info.gratour.jt809core.codec.encoder.bodyencoder.base.{MBEncoder_1600_UpBaseMsg, MBEncoder_9600_DownBaseMsg}
import info.gratour.jt809core.codec.encoder.bodyencoder.ctrl.{MBEncoder_1500_UpCtrlMsg, MBEncoder_9500_DownCtrlMsg}
import info.gratour.jt809core.codec.encoder.bodyencoder.exg.{MBEncoder_1200_UpExgMsg, MBEncoder_9200_DownExgMsg}
import info.gratour.jt809core.codec.encoder.bodyencoder.jt1078.auth.MBEncoder_1700_UpAuthorizeMsg
import info.gratour.jt809core.codec.encoder.bodyencoder.link._
import info.gratour.jt809core.codec.encoder.bodyencoder.manage.MBEncoder_9101_DownManageTotalRecvBackMsg
import info.gratour.jt809core.codec.encoder.bodyencoder.platform.{MBEncoder_1300_UpPlatformMsg, MBEncoder_9300_DownPlatformMsg}
import info.gratour.jt809core.codec.encoder.bodyencoder.warn.{MBEncoder_1400_UpWarnMsg, MBEncoder_9400_DownWarnMsg}

object JT809R2011_MsgBodyEncoderRegistry extends JT809MsgBodyEncoderRegistry {

  private val map: Map[Int, MsgBodyEncoder] = Seq(

    MBEncoder_1001_UpConnectReq,
    MBEncoder_1002_UpConnectRsp,
    MBEncoder_1003_UpDisconnectReq,
    MBEncoder_1004_UpDisconnectRsp,
    MBEncoder_1005_UpLinkTestReq,
    MBEncoder_1006_UpLinkTestRsp,
    MBEncoder_1007_UpDisconnectInform,
    MBEncoder_1008_UpCloseLinkInform,
    MBEncoder_9001_DownConnectReq,
    MBEncoder_9002_DownConnectRsp,
    MBEncoder_9003_DownDisconnectReq,
    MBEncoder_9004_DownDisconnectRsp,
    MBEncoder_9005_DownLinkTestReq,
    MBEncoder_9006_DownLinkTestRsp,
    MBEncoder_9007_DownDisconnectInform,
    MBEncoder_9008_DownCloseLinkInform,

    MBEncoder_9101_DownManageTotalRecvBackMsg,

    MBEncoder_1200_UpExgMsg,
    MBEncoder_9200_DownExgMsg,

    MBEncoder_1300_UpPlatformMsg,
    MBEncoder_9300_DownPlatformMsg,

    MBEncoder_1400_UpWarnMsg,
    MBEncoder_9400_DownWarnMsg,

    MBEncoder_1500_UpCtrlMsg,
    MBEncoder_9500_DownCtrlMsg,

    MBEncoder_1600_UpBaseMsg,
    MBEncoder_9600_DownBaseMsg,



  ).map(e => (e.msgId, e)).toMap

  override def get(msgId: Int): MsgBodyEncoder =
    map.get(msgId).orNull
}
