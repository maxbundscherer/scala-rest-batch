name          := "rest-batch"
version       := "0.1"
scalaVersion  := "2.12.8"

//~ Include circe
val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

//~ Include sttp ~
libraryDependencies += "com.softwaremill.sttp" %% "core" % "1.5.2"