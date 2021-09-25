package info.gratour.jt809core.codec.decoder.bodydecoder

import info.gratour.jt809core.codec.decoder.bodydecoder.base.{MBDecoder_1600_UpBaseMsg, MBDecoder_9600_DownBaseMsg}
import info.gratour.jt809core.codec.decoder.bodydecoder.ctrl.{MBDecoder_1500_UpCtrlMsg, MBDecoder_9500_DownCtrlMsg}
import info.gratour.jt809core.codec.decoder.bodydecoder.exg.{MBDecoder_1200_UpExgMsg, MBDecoder_9200_DownExgMsg}
import info.gratour.jt809core.codec.decoder.bodydecoder.jt1078.auth.{MBDecoder_1700_UpAuthorizeMsg, MBDecoder_9700_DownAuthorizeMsg}
import info.gratour.jt809core.codec.decoder.bodydecoder.link.{MBDecoder_1001_UpConnectReq, MBDecoder_1002_UpConnectRsp, MBDecoder_1003_UpDisconnectReq, MBDecoder_1004_UpDisconnectRsp, MBDecoder_1005_UpLinkTestReq, MBDecoder_1006_UpLinkTestRsp, MBDecoder_1007_UpDisconnectInform, MBDecoder_1008_UpCloseLinkInform, MBDecoder_9001_DownConnectReq, MBDecoder_9002_DownConnectRsp, MBDecoder_9003_DownDisconnectReq, MBDecoder_9004_DownDisconnectRsp, MBDecoder_9005_DownLinkTestReq, MBDecoder_9006_DownLinkTestRsp, MBDecoder_9007_DownDisconnectInform, MBDecoder_9008_DownCloseLinkInform}
import info.gratour.jt809core.codec.decoder.bodydecoder.manage.MBDecoder_9101_DownManageTotalRecvBackMsg
import info.gratour.jt809core.codec.decoder.bodydecoder.platform.{MBDecoder_1300_UpPlatformMsg, MBDecoder_9300_DownPlatformMsg}
import info.gratour.jt809core.codec.decoder.bodydecoder.warn.{MBDecoder_1400_UpWarnMsg, MBDecoder_9400_DownWarnMsg}

object JT809R2011_MsgBodyDecoderRegistry extends JT809MsgBodyDecoderRegistry {

  private val map: Map[Int, JT809MsgBodyDecoder] = Seq(
    MBDecoder_1001_UpConnectReq,
    MBDecoder_1002_UpConnectRsp,
    MBDecoder_1003_UpDisconnectReq,
    MBDecoder_1004_UpDisconnectRsp,
    MBDecoder_1005_UpLinkTestReq,
    MBDecoder_1006_UpLinkTestRsp,
    MBDecoder_1007_UpDisconnectInform,
    MBDecoder_1008_UpCloseLinkInform,
    MBDecoder_9001_DownConnectReq,
    MBDecoder_9002_DownConnectRsp,
    MBDecoder_9003_DownDisconnectReq,
    MBDecoder_9004_DownDisconnectRsp,
    MBDecoder_9005_DownLinkTestReq,
    MBDecoder_9006_DownLinkTestRsp,
    MBDecoder_9007_DownDisconnectInform,
    MBDecoder_9008_DownCloseLinkInform,

    MBDecoder_9101_DownManageTotalRecvBackMsg,

    MBDecoder_1200_UpExgMsg,
    MBDecoder_9200_DownExgMsg,

    MBDecoder_1300_UpPlatformMsg,
    MBDecoder_9300_DownPlatformMsg,

    MBDecoder_1400_UpWarnMsg,
    MBDecoder_9400_DownWarnMsg,

    MBDecoder_1500_UpCtrlMsg,
    MBDecoder_9500_DownCtrlMsg,

    MBDecoder_1600_UpBaseMsg,
    MBDecoder_9600_DownBaseMsg,



  ).map(d => (d.msgId, d))
    .toMap

  override def get(msgId: Int): JT809MsgBodyDecoder =
    map.get(msgId).orNull

}
