package de.maxbundscherer.restbatch.services

import de.maxbundscherer.restbatch.utils.Logger

class RestService extends Logger {

  import de.maxbundscherer.restbatch.models._
  import com.softwaremill.sttp._

  private implicit val httpUrlConnectionBackend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()

  /**
    * Send request
    * @param value JsonReadModel
    * @return RestStatus
    */
  def sendRequest(value: JsonReadModel): RestStatus = {

    logger.debug(s"Send Request ($value)")

    val request: Request[String, Nothing] = value.requestType.trim.toLowerCase match {

      case "get" =>

        sttp.headers(value.headerParams.map(i => i.key -> i.value).toMap)
        sttp.get(Uri(host = value.requestTargetUrl, port = value.requestTargetPort))

      case "post" =>

        sttp.headers(value.headerParams.map(i => i.key -> i.value).toMap)
        sttp.body(value.body)
        sttp.post(Uri(host = value.requestTargetUrl, port = value.requestTargetPort))

      case "put" =>

        sttp.headers(value.headerParams.map(i => i.key -> i.value).toMap)
        sttp.body(value.body)
        sttp.put(Uri(host = value.requestTargetUrl, port = value.requestTargetPort))

      case "patch" =>

        sttp.headers(value.headerParams.map(i => i.key -> i.value).toMap)
        sttp.body(value.body)
        sttp.patch(Uri(host = value.requestTargetUrl, port = value.requestTargetPort))

      case "delete" =>

        sttp.headers(value.headerParams.map(i => i.key -> i.value).toMap)
        sttp.body(value.body)
        sttp.delete(Uri(host = value.requestTargetUrl, port = value.requestTargetPort))

    }

    val response: Id[Response[String]] = request.send()

    RestStatus(statusCode = response.code, response = response.unsafeBody)
  }

}