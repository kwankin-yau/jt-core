package info.gratour.adaptor.impl


import java.lang.reflect.Type
import java.{lang, util}

import com.google.gson.reflect.TypeToken
import info.gratour.adaptor.TermCmdRepo
import info.gratour.adaptor.types.CreateTermCmdReq
import info.gratour.common.types.rest.{Pagination, Reply}
import info.gratour.jtmodel.TermCmd

import scala.collection.mutable.ArrayBuffer

class TermCmdRepoApiImpl(val endPointUrl: String, val authentication: APIAuthentication) extends TermCmdRepo with APIClient {

  private val TERMINAL_CMD_MULTI_REPLY_TYPE = new TypeToken[Reply[TermCmd]]() {}.getType

  private def qry(params: (String, Any)*)(implicit pagination: Pagination = null): util.List[TermCmd] = {
    val r: Reply[TermCmd] = checkReply(get("term_cmd", TERMINAL_CMD_MULTI_REPLY_TYPE, params: _*)(if (pagination == null) Pagination.DEFAULT else pagination))
    if (r.hasData) {
      val list = new util.ArrayList[TermCmd]()
      r.getData.forall(cmd => list.add(cmd))
      list
    } else
      new util.ArrayList[TermCmd]()
  }

//  override def queryById(id: Long): TermCmd = {
//    val list = qry("id" -> id)
//    if (list.isEmpty)
//      null
//    else
//      list.get(0)
//  }

  private def recent: (String, Object) = "reqTm" -> ("[" + java.lang.Long.valueOf(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 1))

  override def queryRecentCmdBySimNo(simNo: String, status: Integer, msgId: String, msgSn: Integer, subCmdType: String): util.List[TermCmd] = {
    val params: ArrayBuffer[(String, Object)] = ArrayBuffer("simNo" -> simNo, "msgId" -> msgId, recent)

    if (status != null)
      params += "status" -> status

    if (msgSn != null)
      params += "msgSn" -> msgSn

    if (subCmdType != null)
      params += "subCmdTyp" -> subCmdType

    qry(params: _*)
  }

  private def put(req: TermCmdRepoApiImpl.UpdateTermCmdReq): TermCmd = {
    val r = checkReply(put[TermCmd]("term_cmd", TermCmdRepoApiImpl.TermCmdReplyType, req))
    r.firstOrNull()
  }


  private def post(req: CreateTermCmdReq): TermCmd = {
    val r = checkReply(post[TermCmd]("term_cmd", TermCmdRepoApiImpl.TermCmdReplyType, req))
    r.firstOrNull()
  }

  private def timeOfNow(time: lang.Long): Long = if (time == null) System.currentTimeMillis() else time

  override def markCmdSuccessById(id: Long, reqTm: Long, ackMsgId: String, ackCode: Integer, ackParams: Object, time: lang.Long): Unit = {
    val req = TermCmdRepoApiImpl.UpdateTermCmdReq(id, reqTm, TermCmd.CMD_STATUS__SUCCESS, null, timeOfNow(time), ackCode, ackMsgId, ackParams)
    put(req)
  }

  override def markCmdFailedById(id: Long, reqTm: Long, ackCode: Integer, failedTime: lang.Long): Unit = {
    val req = TermCmdRepoApiImpl.UpdateTermCmdReq(id, reqTm, TermCmd.CMD_STATUS__FAILED, null, timeOfNow(failedTime), ackCode, null, null)
    put(req)
  }

  override def markCmdCanceledById(id: Long, reqTm: Long, cancelTime: lang.Long): Unit = {
    val req = TermCmdRepoApiImpl.UpdateTermCmdReq(id, reqTm, TermCmd.CMD_STATUS__CANCELED, null, timeOfNow(cancelTime), null, null, null)
    put(req)
  }

  override def markCmdUploaded(id: Long, reqTm: Long, uploadTime: lang.Long): Unit = {
    val req = TermCmdRepoApiImpl.UpdateTermCmdReq(id, reqTm, TermCmd.CMD_STATUS__UPLOADED, null, timeOfNow(uploadTime), null, null, null)
    put(req)
  }

  override def markCmdNotSupportedById(id: Long, reqTm: Long, failedTime: lang.Long): Unit = {
    val req = TermCmdRepoApiImpl.UpdateTermCmdReq(id, reqTm, TermCmd.CMD_STATUS__NOT_SUPPORTED, null, timeOfNow(failedTime), null, null, null)
    put(req)
  }

  override def markCmdSent(id: Long, reqTm: Long, msgSeqNo: Int, sentTime: lang.Long): Unit = {
    val req = TermCmdRepoApiImpl.UpdateTermCmdReq(id, reqTm, TermCmd.CMD_STATUS__SENT, msgSeqNo, timeOfNow(sentTime), null, null, null)
    put(req)
  }

  override def createCmd(cmd: CreateTermCmdReq): TermCmd = {
    post(cmd)
  }

  override def createCmd(cmd: TermCmd): TermCmd = {
    val r = checkReply(post[TermCmd]("term_cmd", TermCmdRepoApiImpl.TermCmdReplyType, cmd))
    r.firstOrNull()
  }
}

object TermCmdRepoApiImpl {

//  case class CreateTermCmdReq(
//                               simNo: String,
//                               plateNo: String,
//                               plateColor: Integer,
//                               msgId: String,
//                               subCmdTyp: String,
//                               reqTm: Long,
//                               cmdSrc: Int,
//                               userId: java.lang.Long,
//                               params: JT808CmdParams)

  case class UpdateTermCmdReq(id: Long, reqTm: Long, status: Int, msgSn: Integer, tm: Long, ackCode: Integer, ackMsgId: String, ackParams: Object)


  val TermCmdReplyType: Type = new TypeToken[Reply[TermCmd]]() {}.getType
}
