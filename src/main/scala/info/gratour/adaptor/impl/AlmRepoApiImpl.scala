/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.impl

import java.lang.reflect.Type
import java.util

import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.AlmRepo
import info.gratour.adaptor.types.{CloseAlmReq, CreateAlmReq}
import info.gratour.common.error.ErrorWithCode
import info.gratour.common.types.rest.{Pagination, Reply}
import info.gratour.common.types.{DateTimeQryCondition, EpochMillis}
import info.gratour.common.utils.StringUtils
import info.gratour.jtmodel.alm.{Alm, AlmAtt, AlmCntStat, AlmParam, CurrAlm}
import info.gratour.jtmodel.govissue.AlmSupervise

class AlmRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends AlmRepo with APIClient {

  /**
   * 查询指定业户适用的特定类型的报警参数
   *
   * @param corpId 业户ID
   * @param typ    报警类型
   * @return
   */
  override def getAlmParam(corpId: Long, typ: String): AlmParam = {
    checkReply(get[AlmParam](AlmRepoApiImpl.ALM_PARAM_PATH, AlmRepoApiImpl.ALM_PARAM_REPLY_TYPE,
      "typ" -> typ
    )).firstOrNull()
  }

  /**
   * 查询终端当前特定类型的报警
   *
   * @param simNo
   * @param typ 报警类型编码 null for all typ
   * @return null if no active alarm
   */
  override def getCurrAlms(simNo: String, typ: String): Array[CurrAlm] = {
    checkReply(getParamsOpt[CurrAlm](AlmRepoApiImpl.CURR_ALM_PATH, AlmRepoApiImpl.CURR_ALM_REPLY_TYPE,
      "simNo" -> Option(simNo),
      "typ" -> Option(typ)
    )).getData
  }


  /**
   * 创建报警
   *
   * @param req 创建报警请求
   */
  override def createAlm(req: CreateAlmReq): Unit =
    checkReply(put(AlmRepoApiImpl.ALM_PATH, req))

  /**
   * 关闭报警
   *
   * @param req 关闭报警请求
   */
  override def closeAlm(req: CloseAlmReq): Unit =
    checkReply(put(AlmRepoApiImpl.ALM_PATH, req))

  //  override def qryAlmById(almId: Long): Alm = {
  //    val (startEpoch, endEpoch) = JT808Utils.dateTimeRangeFromEncodedId(almId)
  //
  //    implicit val pagination: Pagination = Pagination.DEFAULT
  //
  //    checkReply(get[Alm](AlmRepoApiImpl.ALM_PATH, AlmRepoApiImpl.ALM_REPLY_TYPE,
  //      "id" -> almId,
  //      "tm1$ge" -> startEpoch,
  //      "tm1$lt" -> endEpoch
  //    )).firstOrNull()
  //  }

  override def createAlmAtt(almAtt: AlmAtt): Unit =
    checkReply(post(AlmRepoApiImpl.ALM_ATT_PATH, AlmRepoApiImpl.ALM_ATT_REPLY_TYPE, almAtt))

  override def qryAlmAtts(almId: Long, tm1: DateTimeQryCondition): util.List[AlmAtt] = {
    val r = checkReply(get[AlmAtt](AlmRepoApiImpl.ALM_ATT_PATH, AlmRepoApiImpl.ALM_ATT_REPLY_TYPE,
      "tm1" -> tm1.toDateTimeExpr,
      "id" -> almId
    )(Pagination.DEFAULT))

    r.dataList()
  }

  override def qryAlmByTm1Typ(tm1: Long, typ: Short): Alm = {
    val r = checkReply(get[Alm](AlmRepoApiImpl.ALM_PATH, AlmRepoApiImpl.ALM_REPLY_TYPE,
      "tm1" -> EpochMillis(tm1),
      "typ" -> StringUtils.intToHex(typ, 4)
    )(Pagination.DEFAULT))


    r.firstOrNull()
  }



  override def qryAlmCntStat(plateNo: String, plateColor: Int, tm1: DateTimeQryCondition, almTypes: Array[String]): util.List[AlmCntStat] = {
    if (almTypes == null)
      throw ErrorWithCode.invalidParam("almTypes")


    val r = checkReply(get[JsonObject](AlmRepoApiImpl.ALM_CNT_STAT_PATH, AlmRepoApiImpl.ALM_CNT_STAT_REPLY_TYPE,
      "plateNo" -> plateNo,
      "plateColor" -> plateColor,
      "tm1" -> tm1.toDateTimeExpr,
      "typ$in" -> almTypes.mkString(",")
    )(Pagination.DEFAULT))

    r.map(obj => {
      val r = new AlmCntStat
      r.setVehId(obj.get("vehId").getAsLong)
      r.setPlateNo(obj.get("plateNo").getAsString)
      r.setPlateColor(obj.get("plateColor").getAsInt)
      r.setGrpId(obj.get("grpId").getAsLong)
      r.setGrpName(obj.get("grpName").getAsString)

      obj.keySet().forEach(key => {
        if (key.length == 5 && key.startsWith("c")) {
          val cnt = obj.get(key).getAsInt
          val entry = new AlmCntStat.AlmCntStatEntry
          entry.setTyp(key.substring(1))
          entry.setCount(cnt)

          r.add(entry)
        }

      })

      r
    }).dataList()
  }

}

object AlmRepoApiImpl {
  val ALM_PARAM_PATH = "almparam"
  val ALM_PARAM_REPLY_TYPE: Type = new TypeToken[Reply[AlmParam]]() {}.getType

  val CURR_ALM_PATH = "alm/curr"
  val CURR_ALM_REPLY_TYPE: Type = new TypeToken[Reply[CurrAlm]]() {}.getType

  val ALM_PATH = "alm"
  val ALM_REPLY_TYPE: Type = new TypeToken[Reply[Alm]]() {}.getType

  val ALM_ATT_PATH = "alm/att"
  val ALM_ATT_REPLY_TYPE: Type = new TypeToken[Reply[AlmAtt]]() {}.getType

  val AM_SUPERVISE_PATH = "alm_supervise"

  val ALM_CNT_STAT_PATH = "report/alm_cnt_stat"
  val ALM_CNT_STAT_REPLY_TYPE: Type = new TypeToken[Reply[JsonObject]]() {}.getType
}
