import java.util.Date

//import event.{BaseEvent, EventOffsetAndHashValue}
import spray.json.DefaultJsonProtocol

/**
  * Created by prayagupd
  * on 12/27/16.
  */

object Models {
  case class ApplicationStarted(name: String)
  case class SomethingHappened(name: String)

  case class Acknowledge(status: String)

  object ServiceJsonProtoocol extends DefaultJsonProtocol {
    implicit val applicationStarted = jsonFormat1(ApplicationStarted)
    implicit val somethingHappened = jsonFormat1(SomethingHappened)
    implicit val ack = jsonFormat1(Acknowledge)
  }
}
