package info.gratour.adaptor.impl


import java.lang.reflect.Type
import java.nio.charset.StandardCharsets
import java.time.LocalDate
import java.util.concurrent.TimeUnit

import com.google.gson.{Gson, GsonBuilder, JsonElement, JsonObject, JsonParser}
import com.typesafe.scalalogging.Logger
import info.gratour.adaptor.mq.dto.CmdAck
import info.gratour.adaptor.mq.materializer.{CmdAckMaterializer, TermCmdMaterializer}
import info.gratour.adaptor.types.APIException
import info.gratour.common.error.{ErrorWithCode, Errors}
import info.gratour.common.lang.JavaByteArray
import info.gratour.common.types.EpochMillis
import info.gratour.common.types.json.{ByteArrayHexMaterializer, EpochMillisMaterializer, LocalDateMaterializer}
import info.gratour.common.types.rest.{Pagination, RawReply, Reply}
import info.gratour.common.utils.LoanPattern._
import info.gratour.jtmodel.TermCmd
import okhttp3._

trait APIAuthentication {

  def handle(builder: Request.Builder): Request.Builder
}

trait TokenAuthentication extends APIAuthentication {

  def authToken: String

  override def handle(builder: Request.Builder): Request.Builder = {
    val token = authToken
    if (token != null)
      builder.addHeader("X-Auth-Token", token)

    builder
  }

}

trait APIClient {


  import APIClient.logger

  def gson: Gson = APIClient.gson

  def endPointUrl: String

  def authentication: APIAuthentication


  protected val parsedEndPointUrl: HttpUrl = HttpUrl.parse(endPointUrl)

  protected def initClient: OkHttpClient = new OkHttpClient.Builder()
    .connectTimeout(15, TimeUnit.SECONDS)
    .readTimeout(20, TimeUnit.SECONDS)
    .callTimeout(30, TimeUnit.SECONDS)
    .build()

  protected lazy val client: OkHttpClient = initClient

  def getClient: OkHttpClient = client

  protected def urlBuilder(path: String, params: Seq[(String, Any)]): HttpUrl.Builder = {
    val urlBuilder = parsedEndPointUrl.newBuilder()
    val paths = path.split("/")
    paths.foreach(p => urlBuilder.addPathSegment(p))

    if (params != null) {
      params.foreach(e => {
        urlBuilder.addQueryParameter(e._1, e._2.toString)
      })
    }

    urlBuilder
  }

  protected def urlBuilderParamsOpt(path: String, params: Seq[(String, Option[_])]): HttpUrl.Builder = {
    val urlBuilder = parsedEndPointUrl.newBuilder()
    val paths = path.split("/")
    paths.foreach(p => urlBuilder.addPathSegment(p))

    if (params != null) {
      params.foreach(e => {
        val opt = e._2

        if (opt.isDefined)
          urlBuilder.addQueryParameter(e._1, opt.get.toString)
      })
    }

    urlBuilder
  }

  protected def url(path: String, params: Seq[(String, Any)]): HttpUrl = urlBuilder(path, params).build()

  protected def urlParamsOpt(path: String, params: Seq[(String, Option[_])]): HttpUrl = urlBuilderParamsOpt(path, params).build()

  def checkReply[T <: RawReply](r: T): T = {
    if (!r.ok())
      throw new APIException(r.getMessage)

    r
  }

  protected trait Converter[T] {
    def fromJson(gson: Gson, s: String): T
  }



  def call[T](req: Request, converter: Converter[T]): T = {
    try {
      using(client.newCall(req).execute()) {
        resp =>
          val body = resp.body()
          if (body != null) {
            val str = body.string()
            APIClient.logger.whenDebugEnabled {
              APIClient.logger.debug(s"Response of $req => STATUS: [${resp.code()}] $str")
            }

            val category = resp.code() / 100
            if (category != 2)
              throw new ErrorWithCode(Errors.EXECUTION_ERROR, "HTTP Status: " + resp.code() + "\n" + resp.message() + "\n" + str)

            converter.fromJson(gson, str)
          } else
            throw new RuntimeException(s"API Server response empty body: $resp.")
      }
    } catch {
      case t: Throwable =>
        APIClient.logger.error(s"Error occurred when serving $req.", t)
        throw t
    }
  }

  def call[T](req: Request, typeOfReply: Type): Reply[T] = {
    call[Reply[T]](req, new Converter[Reply[T]] {
      override def fromJson(gson: Gson, s: String): Reply[T] = {
        gson.fromJson(s, typeOfReply)
      }
    })
//    try {
//      using(client.newCall(req).execute()) {
//        resp =>
//          val body = resp.body()
//          if (body != null) {
//            val str = body.string()
//            APIClient.logger.whenDebugEnabled {
//              APIClient.logger.debug(s"Response of $req => STATUS: [${resp.code()}] $str")
//            }
//
//            val category = resp.code() / 100
//            if (category != 2)
//              throw new ErrorWithCode(Errors.EXECUTION_ERROR, "HTTP Status: " + resp.code() + "\n" + resp.message() + "\n" + str)
//
//            gson.fromJson(str, typeOfReply)
//          } else
//            throw new RuntimeException(s"API Server response empty body: $resp.")
//      }
//    } catch {
//      case t: Throwable =>
//        APIClient.logger.error(s"Error occurred when serving $req.")
//        throw t
//    }
  }

  def callJson(req: Request): JsonElement = {
    call[JsonElement](req, new Converter[JsonElement] {
      override def fromJson(gson: Gson, s: String): JsonElement = {
        JsonParser.parseString(s)
      }
    })
  }

  def call[T](req: Request, classOfReply: Class[T]): T = {
    call[T](req, new Converter[T] {
      override def fromJson(gson: Gson, s: String): T = {
        gson.fromJson(s, classOfReply)
      }
    })
//    try {
//      using(client.newCall(req).execute()) {
//        resp =>
//          val body = resp.body()
//          if (body != null) {
//            val str = body.string()
//            APIClient.logger.whenDebugEnabled {
//              APIClient.logger.debug(s"Response of $req => STATUS: [${resp.code()}] $str")
//            }
//
//            val category = resp.code() / 100
//            if (category != 2)
//              throw new ErrorWithCode(Errors.EXECUTION_ERROR, "HTTP Status: " + resp.code() + "\n" + resp.message() + "\n" + str)
//
//            gson.fromJson(str, classOfReply)
//          } else
//            throw new RuntimeException(s"API Server response empty body: $resp.")
//      }
//    } catch {
//      case t: Throwable =>
//        APIClient.logger.error(s"Error occurred when serving $req.")
//        throw t
//    }
  }

  private def addPaginationParams(params: Seq[(String, Any)], pagination: Pagination): Seq[(String, Any)] =
    if (pagination != null)
      params :+ ("__limit" -> pagination.limit) :+ ("__page" -> pagination.page)
    else
      params

  def get[T](path: String, typeOfReply: Type, params: (String, Any)*)(implicit pagination: Pagination = null): Reply[T] = {
    val p = addPaginationParams(params, pagination)
    val builder = new Request.Builder()
      .url(url(path, p))

    val req = authentication.handle(builder)
      .build()

    call(req, typeOfReply)
  }

  def getJson(path: String, params: (String, Any)*)(implicit pagination: Pagination = null): JsonElement = {
    val p = addPaginationParams(params, pagination)
    val builder = new Request.Builder()
      .url(url(path, p))

    val req = authentication.handle(builder)
      .build()

    callJson(req)
  }

  def getParamsOpt[T](path: String, typeOfReply: Type, params: (String, Option[_])*)(implicit pagination: Pagination = null): Reply[T] = {
    val p =
      if (pagination != null)
        params :+ ("__limit" -> Some(pagination.limit)) :+ ("__page" -> Some(pagination.page))
    else
        params

    val builder = new Request.Builder()
      .url(urlParamsOpt(path, p))

    val req = authentication.handle(builder)
      .build()

    call(req, typeOfReply)
  }

  def getJsonParamsOpt[T](path: String, params: (String, Option[_])*)(implicit pagination: Pagination = null): JsonElement = {
    val p =
      if (pagination != null)
        params :+ ("__limit" -> Some(pagination.limit)) :+ ("__page" -> Some(pagination.page))
      else
        params

    val builder = new Request.Builder()
      .url(urlParamsOpt(path, p))

    val req = authentication.handle(builder)
      .build()

    callJson(req)
  }

  protected val JSON: MediaType = MediaType.get("application/json; charset=utf-8")

  protected def postRequest(path: String, rb: RequestBody): Request = {
    val builder = new Request.Builder()
      .url(url(path, null))
      .post(rb)


    authentication.handle(builder).build()
  }

  def post[T](path: String, typeOfReply: Type, body: Object): Reply[T] = {
    val json = gson.toJson(body)
    logger.debug("POST " + json)
    val rb = RequestBody.create(json.getBytes(StandardCharsets.UTF_8), JSON)

    val req = postRequest(path, rb)
    call(req, typeOfReply)
  }

  def post[T](path: String, classOfReply: Class[Reply[T]], body: Object): Reply[T] = {
    val json = gson.toJson(body)
    logger.debug("POST " + json)
    val rb = RequestBody.create(json.getBytes(StandardCharsets.UTF_8), JSON)

    val req = postRequest(path, rb)
    call(req, classOfReply)
  }

  def post(path: String, body: Object): RawReply = {
    val json = gson.toJson(body)
    logger.debug("POST " + json)
    val rb = RequestBody.create(json.getBytes(StandardCharsets.UTF_8), JSON)

    val req = postRequest(path, rb)

    call(req, classOf[RawReply])
  }


  protected def putRequest(path: String, rb: RequestBody): Request = {
    val builder = new Request.Builder()
      .url(url(path, null))
      .put(rb)

    authentication.handle(builder).build()
  }

  def put[T](path: String, typeOfReply: Type, body: Object): Reply[T] = {
    val json = gson.toJson(body)
    logger.debug("PUT " + json)
    val rb = RequestBody.create(json.getBytes(StandardCharsets.UTF_8), JSON)

    val req = putRequest(path, rb)

    call(req, typeOfReply)
  }

  def put[T](path: String, classOfReply: Class[T], body: Object): Reply[T] = {
    val json = gson.toJson(body)
    logger.debug("PUT " + json)
    val rb = RequestBody.create(json.getBytes(StandardCharsets.UTF_8), JSON)

    val req = putRequest(path, rb)

    call(req, classOfReply)
  }

  def put(path: String, body: Object): RawReply = {
    val json = gson.toJson(body)
    logger.debug("PUT " + json)
    val rb = RequestBody.create(json.getBytes(StandardCharsets.UTF_8), JSON)

    val req = putRequest(path, rb)

    call(req, classOf[RawReply])
  }

  def delete(path: String, params: (String, Any)*): RawReply = {
    val builder = new Request.Builder()
      .url(url(path, params))

    val req = authentication.handle(builder).delete().build()

    call(req, classOf[RawReply])
  }
}

object APIClient {

  private val logger = Logger[APIClient]

  def gsonBuilder: GsonBuilder =
    new GsonBuilder()
      .registerTypeAdapter(JavaByteArray.BYTE_ARRAY_CLASS, new ByteArrayHexMaterializer)
      .registerTypeAdapter(classOf[TermCmd], new TermCmdMaterializer)
      .registerTypeAdapter(classOf[CmdAck], new CmdAckMaterializer)
      .registerTypeAdapter(classOf[EpochMillis], new EpochMillisMaterializer)
      .registerTypeAdapter(classOf[LocalDate], new LocalDateMaterializer)


  val gson: Gson = gsonBuilder.create()
}
