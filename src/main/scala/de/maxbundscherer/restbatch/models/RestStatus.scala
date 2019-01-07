package de.maxbundscherer.restbatch.models

case class RestStatus (
                      statusCode: Int,
                      response: String
                      ) {

  /**
    * Get result String
    * @param requestName String Name of request
    * @return String
    */
  def getResultString(requestName: String): String = s"$statusCode\t'$requestName'\t'$response'"
  
}