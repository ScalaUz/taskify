package taskify.views

import com.raquo.laminar.api.L._

object LoginPageView {
  def apply(): HtmlElement =
    div(
      cls := "flex flex-col items-center bg-[#F5F5F7] justify-center w-full h-screen",
      div(
        cls := "p-8 mt-12 bg-white w-96 shadow-6xl rounded-xl space-y-7",
        h1(cls := "text-2xl font-bold", "Kirish"),
        div(
          cls := "flex flex-col space-y-2 mt-11",
          label(forId := "login", cls := "text-xs font-medium", "Telefon raqam"),
          input(
            tpe         := "text",
            idAttr      := "login",
            placeholder := "+998(00) 000-00-00",
            cls := "h-10 custom-input-bg border bg-[#e0e7ff3b] px-3 border-[#E0E7FF] outline-none rounded-md",
          ),
        ),
        div(
          cls := "flex flex-col space-y-2",
          label(forId := "password", cls := "text-xs font-medium", "Parol"),
          div(
            cls := "relative",
            input(
              idAttr := "password",
              cls := "bg-[#e0e7ff3b] px-3 w-full h-10 border border-[#E0E7FF] rounded-md outline-none",
              placeholder := "Parolni kiriting",
            ),
          ),
        ),
        button(
          cls := "h-[50px] w-full font-medium text-[15px] bg-[#2E5BFF] rounded-md flex items-center justify-center text-white",
          "Kirish",
        ),
      ),
    )
}
