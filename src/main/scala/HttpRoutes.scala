

import java.util.concurrent.ConcurrentLinkedDeque

import Models.{Acknowledge, SomethingHappened}
import akka.actor.ActorSystem
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.collection.JavaConverters._

/**
  * Created by prayagupd
  * on 12/27/16.
  */

trait HttpRoutes {
  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer

  val stream = new ConcurrentLinkedDeque[SomethingHappened]()
  stream.add(SomethingHappened(name = "application started"))

  import Models.ServiceJsonProtoocol._

  val route =
  //TODO authenticate + authorization
  // http://doc.akka.io/docs/akka-stream-and-http-experimental/1.0/scala/http/routing-dsl/directives/security-directives/index.html
    path("ingest") {
      post {
        entity(as[SomethingHappened]) {
          event => complete {

            //TODO write to stream
            stream.add(event)

            Acknowledge(status = "Ok")
          }
        }
      }
    } ~
  path("events") {
    get {
      complete {
        stream.asScala
      }
    }
  }
}
