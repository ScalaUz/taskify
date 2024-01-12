import org.scalajs.linker.interface.ModuleSplitStyle

lazy val taskify = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
//  .enablePlugins(JSDependenciesPlugin)
  .settings(
    scalaVersion                    := "2.13.10",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("taskify")))
    },
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.4.0",
      "com.raquo"    %%% "laminar"     % "15.0.1",
    ),
  )
Global / onChangedBuildSource := ReloadOnSourceChanges
