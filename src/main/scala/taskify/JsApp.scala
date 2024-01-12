package taskify

import com.raquo.laminar.api.L._
import com.raquo.waypoint.Route
import com.raquo.waypoint.Router
import com.raquo.waypoint._
import io.circe.Codec
import io.circe.Json
import io.circe.generic.semiauto.deriveCodec
import io.circe.syntax.EncoderOps
import org.scalajs.dom
import taskify.views.LoginPageView

object JsApp extends App {
  println("-- Scala.js app start --")

  sealed trait Page
  case object LoginPage extends Page
  implicit val pageCodec: Codec[Page] = deriveCodec

  lazy val container = dom.document.getElementById("root")

  val loginRoute = Route.static(LoginPage, root / endOfSegments)

  val router = new Router[Page](
    routes = List(loginRoute),
    getPageTitle = _ => "", // displayed in the browser tab next to favicon
    serializePage = page => page.asJson.spaces2, // serialize page data for storage in History API log
    deserializePage = pageStr =>
      Json.fromString(pageStr).as[Page].getOrElse(throw new Exception("aaaaaa")), // deserialize the above
  )(
    popStateEvents = windowEvents(_.onPopState), // this is how Waypoint avoids an explicit dependency on Laminar
    owner = unsafeWindowOwner, // this router will live as long as the window
  )

  def renderPage(page: Page): HtmlElement =
    page match {
      case LoginPage => LoginPageView()
    }

  val appElement: Div = div(
    h1("Routing App"),
    child <-- router.currentPageSignal.map(renderPage),
  )
  render(container, appElement)
}
