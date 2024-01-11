package taskify
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html

object MainComponent {
  class Backend($ : BackendScope[Unit, String]) {
    val inputRef = Ref[html.Input]

    def handleChange(e: ReactEventFromInput) =
      $.setState(e.target.value)

    def clearAndFocusInput =
      $.setState("", inputRef.foreach(_.focus()))

    def render(state: String) =
      <.div(
        <.div(^.onClick --> clearAndFocusInput, "Click to Focus and Reset"),
        <.input(^.value := state, ^.onChange ==> handleChange)
          .withRef(inputRef),
      )
  }

  val App = ScalaComponent
    .builder[Unit]
    .initialState("")
    .renderBackend[Backend]
    .build
}
