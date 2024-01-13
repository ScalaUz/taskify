package taskify.components

import com.raquo.laminar.tags._
import com.raquo.laminar.api.L._
import com.raquo.laminar.codecs._
import org.scalajs.dom

import scala.scalajs.js

object Sonner {
  @js.native
  trait RawElement extends js.Object {
    def value: Int = js.native
  }

  type Ref = dom.html.Element with RawElement // 1

  private val tag: HtmlTag[Ref] = htmlTag("stars-rating") // 2

  val maxStars: HtmlAttr[Int] = htmlAttr("max", IntAsStringCodec) // 3
  val value: HtmlAttr[Int] = htmlAttr("value", IntAsStringCodec)

  object events {
    val onChange = new EventProp[EventWithPreciseTarget[Ref]]("change") // 4
  }

  type ModFunction = this.type => Mod[ReactiveHtmlElement[Ref]]

  // 5
  def apply(mods: ModFunction*): HtmlElement = tag(
    mods.map(_(this))
  )
}
