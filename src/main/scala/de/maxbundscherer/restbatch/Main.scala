package de.maxbundscherer.restbatch

import de.maxbundscherer.restbatch.utils.Logger

object Main extends App with Logger {

  import de.maxbundscherer.restbatch.services._
  import de.maxbundscherer.restbatch.models._

  val fileReaderService: FileReaderService = new FileReaderService()
  val restService      : RestService       = new RestService()

  fileReaderService

    .getAllFileNamesFromDir(dirName = "jobs", fileExtender = "json")
    .map(fileName => fileReaderService.readFromFile(fileName))
    .foreach(requestModel => {

      val result: RestStatus = restService.sendRequest(requestModel)
      logger.info(result.getResultString(requestModel.requestName))

    })

}