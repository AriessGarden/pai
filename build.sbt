import sbt._
import Keys._
import play.Project._

  val appName = "PaiMongoDB"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
  // Add your project dependencies here,
      javaCore,
  //  javaJdbc,
  //  javaEbean,
    "org.mindrot" % "jbcrypt" % "0.3m",
    "com.typesafe" %% "play-plugins-mailer" % "2.2.0",
    "org.mongojack" % "mongojack" % "2.0.0-RC5",
    "org.mongodb" % "mongo-java-driver" % "2.10.1",
    "com.mortennobel" % "java-image-scaling" % "0.8.5")

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here 
    resolvers += "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
    resolvers += "Daniel's Repository" at "http://danieldietrich.net/repository/snapshots/",
    resolvers += "Morphia repository" at "http://morphia.googlecode.com/svn/mavenrepo")
