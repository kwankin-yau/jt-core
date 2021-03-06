/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.ackparams

import com.google.gson.Gson
import info.gratour.adaptor.mq.dto.types.MQEventAddt_0702_DriverIdentity
import info.gratour.common.Consts
import info.gratour.jt808core.protocol.msg.{JT1078Msg_1003_QryAVAttrsAck, JT1078Msg_1205_QryAVResAck, JT1078Msg_9003_QryAVAttrs, JT1078Msg_9205_QryAVRes, JT808Msg_0104_QryParamsAck, JT808Msg_0107_QryAttrsAck, JT808Msg_0201_QryLocationAck, JT808Msg_0302_InquestAnswer, JT808Msg_0500_VehCtrlAck, JT808Msg_0700_VTDRData, JT808Msg_0702_DriverIdentity, JT808Msg_0802_StoredMediaSearchAck, JT808Msg_0805_TakePhotoAck, JT808Msg_8104_QryAllParams, JT808Msg_8105_TerminalCtrl, JT808Msg_8106_QrySpecialParams, JT808Msg_8107_QryAttrs, JT808Msg_8201_QryLocation, JT808Msg_8302_Inquest, JT808Msg_8500_VehCtrl, JT808Msg_8700_VTDRDataCollectReq, JT808Msg_8702_DriverIdentityReq, JT808Msg_8801_TakePhoto, JT808Msg_8802_StoredMediaSearch, JT808Msg_8805_SingleStoredMediaReq}
import info.gratour.jtcommon.{JTConsts, JTUtils}

object AckParamsParser {

  private val map: Map[Int, Class[_ <: JT808AckParams]] = Seq(

    classOf[JT808AckParams_0104_QryParamsAck],
    classOf[JT808AckParams_0107_QryAttrsAck],
    classOf[JT808AckParams_0201_QryLocationAck],
    classOf[JT808AckParams_0302_InquestAnswer],
    classOf[JT808AckParams_0500_VehCtrlAck],
    classOf[JT808AckParams_0700_VTDRData],
    classOf[JT808AckParams_0802_StoredMediaSearchAck],
    classOf[JT808AckParams_0805_TakePhotoAck],
    classOf[JT1078AckParams_1003_QryAVAttrsAck],
    classOf[JT1078AckParams_1205_QryAVResAck],
    classOf[MQEventAddt_0702_DriverIdentity]

  ).map(c => {
    JTUtils.jtMsgIdOf(c) -> c
  }).toMap

  def clazzOf(msgId: Int): Class[_] =
    map.get(msgId).orNull

  def fromJsonBySrcMsgId(srcMsgId: Int, json: String, gson: Gson): JT808AckParams = {
    if (json == null)
      return null

    val ackMsgId =
      srcMsgId match {
        case JT808Msg_8104_QryAllParams.MSG_ID | JT808Msg_8106_QrySpecialParams.MSG_ID =>
          JT808Msg_0104_QryParamsAck.MSG_ID

        case JT808Msg_8107_QryAttrs.MSG_ID =>
          JT808Msg_0107_QryAttrsAck.MSG_ID

        case JT808Msg_8201_QryLocation.MSG_ID =>
          JT808Msg_0201_QryLocationAck.MSG_ID

        case JT808Msg_8302_Inquest.MSG_ID =>
          JT808Msg_0302_InquestAnswer.MSG_ID

        case JT808Msg_8500_VehCtrl.MSG_ID =>
          JT808Msg_0500_VehCtrlAck.MSG_ID

        case JT808Msg_8700_VTDRDataCollectReq.MSG_ID =>
          JT808Msg_0700_VTDRData.MSG_ID

        case JT808Msg_8702_DriverIdentityReq.MSG_ID =>
          JT808Msg_0702_DriverIdentity.MSG_ID

        case JT808Msg_8802_StoredMediaSearch.MSG_ID =>
          JT808Msg_0802_StoredMediaSearchAck.MSG_ID

        case JT808Msg_8801_TakePhoto.MSG_ID =>
          JT808Msg_0805_TakePhotoAck.MSG_ID

        case JT1078Msg_9003_QryAVAttrs.MSG_ID =>
          JT1078Msg_1003_QryAVAttrsAck.MSG_ID

        case JT1078Msg_9205_QryAVRes.MSG_ID =>
          JT1078Msg_1205_QryAVResAck.MSG_ID

        case _ =>
          0
      }

    if (ackMsgId == 0)
      return null

    val clzz = map.get(ackMsgId).orNull
    if (clzz == null)
      throw new RuntimeException(s"Ack params for `${JTUtils.msgIdToHex(ackMsgId)}` was not found.")

    gson.fromJson(json, clzz)
  }

  def fromJsonBySrcMsgId(srcMsgId: Int, json: String): JT808AckParams =
    fromJsonBySrcMsgId(srcMsgId, json, JTConsts.GSON)


  def fromJson(ackMsgId: Int, json: String, gson: Gson): JT808AckParams = {
    if (json == null)
      return null

    val clzz = map.get(ackMsgId).orNull
    if (clzz == null)
      throw new RuntimeException(s"Ack params for `${JTUtils.msgIdToHex(ackMsgId)}` was not found.")

    gson.fromJson(json, clzz)
  }

  def fromJson(ackMsgId: Int, json: String): JT808AckParams =
    fromJson(ackMsgId, json, JTConsts.GSON)


}
