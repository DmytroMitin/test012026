ThisBuild / scalaVersion := "2.13.18"

lazy val root = (project in file("."))
  .settings(
    name := "hello-world",
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.2.2" % Test,
      "com.lihaoyi" %% "os-lib" % "0.11.8" % Test
    ),
    testFrameworks += new TestFramework("munit.Framework")
  )
