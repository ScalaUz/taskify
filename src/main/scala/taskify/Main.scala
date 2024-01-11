package taskify

import org.scalajs.dom.document

object Main extends App {
  MainComponent.App().renderIntoDOM(document.getElementById("app"))
}
