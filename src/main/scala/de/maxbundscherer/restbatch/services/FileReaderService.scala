package de.maxbundscherer.restbatch.services

import de.maxbundscherer.restbatch.utils.Logger

class FileReaderService extends Logger {

  import de.maxbundscherer.restbatch.models._

  import java.io._
  import scala.io.Source
  import io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

  /**
    * Read from file
    * @param fileName String
    * @return JsonReadModel
    */
  def readFromFile(fileName: String): JsonReadModel = {

    logger.debug(s"Read from file ($fileName)")

    val content: String = Source.fromFile(fileName).getLines.mkString

    decode[JsonReadModel](content).right.get
  }

  /**
    * Get all files from dir
    * @param dirName String
    * @param fileExtender String (filter by fileExtender)
    * @return Vector with Strings (fileNames)
    */
  def getAllFileNamesFromDir(dirName: String, fileExtender: String): Vector[String] = {

    logger.debug(s"Get all files from '$dirName'")
    
    val localDir: File = new File(s"$dirName")

    val files: List[File] = localDir.listFiles.filter(_.isFile).toList.filter { file => file.getName.endsWith(fileExtender) }

    files.map(_.getAbsolutePath).toVector
  }

}