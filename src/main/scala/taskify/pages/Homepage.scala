package taskify.pages

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import scala.scalajs.js.annotation.JSImport

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import taskify.components.Counter

@JSExportTopLevel("Homepage", "Homepage")
object Homepage extends App {
//  @js.native
//  @JSImport("@src/taskify/pages/Homepage.module.css", JSImport.Namespace)
//  val styles: js.Dictionary[String] = js.native

  val Homepage = ScalaComponent
    .builder[Unit]
    .renderStatic(<.div("Hello!"))
    .build

  Homepage.toJsComponent.raw
}
