package de.maxbundscherer.restbatch.utils

trait Logger {

  //TODO: Implement real logger

  val LOGGER_NAME            : String = "Root-Logger"
  val LOGGER_DEBUG_ENABLED   : Boolean = false

  object logger {

    private def outputConverter(msg: String, prefix: String): String = s"$LOGGER_NAME [$prefix]: $msg"

    def info(msg: String) : Unit = println(outputConverter(msg, "INFO"))
    def debug(msg: String): Unit = if(LOGGER_DEBUG_ENABLED) println(outputConverter(msg, "DEBUG"))

  }

}