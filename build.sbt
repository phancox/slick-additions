crossScalaVersions := Seq("2.10.5", "2.11.6")

scalaVersion := "2.11.6"

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.0.0-RC3"

name := "slick-additions"

organization := "io.github.nafg"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.0" % "test"

libraryDependencies += "com.h2database" % "h2" % "1.3.170" % "test"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "0.9.28" % "test"

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % "provided"

libraryDependencies ++= (
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 10)) =>
      Seq("org.scalamacros" %% "quasiquotes" % "2.1.0-M5" cross CrossVersion.binary)
    case _ =>
      Nil
  }
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)

scalacOptions ++= Seq("-deprecation", "-unchecked")
