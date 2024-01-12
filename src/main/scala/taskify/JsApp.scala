package taskify

import com.raquo.laminar.api.L._
import org.scalajs.dom

object JsApp extends App {
  println("-- Scala.js app start --")

  lazy val container = dom.document.getElementById("root")
  val nameVar = Var(initial = "world")

  lazy val appElement =
    div(
      label("Your name: "),
      input(
        placeholder := "Enter your name here",
        onInput.mapToValue --> nameVar,
      ),
      p(
        cls("text-3xl font-bold text-blue-500 underline"),
        "Hello, ",
        child.text <-- nameVar.signal.map(_.toUpperCase),
      ),
    )
  render(container, appElement)
}
