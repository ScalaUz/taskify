import org.scalajs.linker.interface.ModuleSplitStyle

lazy val circeVersion = "0.14.1"

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
      "org.scala-js" %%% "scalajs-dom"    % "2.4.0",
      "com.raquo"    %%% "laminar"        % "16.0.0",
      "com.raquo"    %%% "waypoint"       % "7.0.0",
      "io.circe"     %%% s"circe-core"    % circeVersion,
      "io.circe"     %%% s"circe-generic" % circeVersion,
    ),
  )
Global / onChangedBuildSource := ReloadOnSourceChanges
