package de.maxbundscherer.restbatch.models

case class HeaderParam (
                          key: String,
                          value: String
                        )

/**
  * JsonReadModel
  * @param requestName String Name of request
  * @param requestTargetUrl String Url
  * @param requestTargetPort Int Port
  * @param requestType String Only allowed: 'GET', 'POST', 'PUT', 'PATCH', 'DELETE'
  * @param headerParams Vector with HeaderParam
  * @param body String Body Payload
  */
case class JsonReadModel (
                          requestName: String,
                          requestTargetUrl: String,
                          requestTargetPort: Int,
                          requestType: String,
                          headerParams: Vector[HeaderParam],
                          body: String
                         )