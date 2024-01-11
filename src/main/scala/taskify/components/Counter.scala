package taskify.components

import japgolly.scalajs.react.CtorType
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.ScalaFn.Component
import japgolly.scalajs.react.hooks.Hooks.UseState
import japgolly.scalajs.react.vdom.html_<^._
object Counter {
  def apply(): Component[Unit, CtorType.Nullary] =
    ScalaFnComponent
      .withHooks[Unit]
      .useState(0)
      .render((_: Unit, count: UseState[Int]) =>
        <.div(
          ^.className := "flex items-center justify-between",
          <.p(s"You clicked ${count.value} times"),
          <.button(
            ^.className := "bg-blue-600 hover:bg-blue-700 text-white text-sm px-4 py-2 border rounded-full",
            ^.onClick --> count.modState(_ + 1),
            "Click me",
          ),
        )
      )
}
