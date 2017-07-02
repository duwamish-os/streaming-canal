name := "streaming-canal"

version := "1.0"

scalaVersion := "2.11.5"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += Resolver.mavenLocal

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-http-experimental" % "1.0",
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "1.0",
    "nihilos" %% "streaming-driver" % "1.0",
    "org.apache.kafka" % "kafka_2.11" % "0.10.1.1",
    "org.apache.kafka" % "kafka-clients" % "0.10.1.1",
    "com.typesafe.akka" %% "akka-http-testkit-experimental" % "1.0",
    "org.scalatest" %% "scalatest" % "2.2.5" % "test"
  )
}
