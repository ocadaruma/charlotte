lazy val charlotte = (project in file("."))
  .settings(
    name := "charlotte",
    version := "0.1.0",
    scalaVersion := "2.11.8"
  )
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.6" % Test,
      "org.mockito" % "mockito-core" % "1.10.19" % Test
    )
  )
