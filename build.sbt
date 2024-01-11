import org.scalajs.linker.interface.ModuleSplitStyle

lazy val `task-management` = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .enablePlugins(JSDependenciesPlugin)
  .settings(
    scalaVersion := "2.13.10",

    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "livechart" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("task-management")))
    },

    /* Depend on the scalajs-dom library.
     * It provides static types for the browser DOM APIs.
     */
    libraryDependencies ++= Seq(
      "org.scala-js"                      %%% "scalajs-dom" % "2.4.0",
      "com.github.japgolly.scalajs-react" %%% "core"        % "2.1.1",
    ),
    jsDependencies ++= Seq(
      "org.webjars.npm" % "react" % "18.2.0"
        / "umd/react.development.js"
        minified "umd/react.production.min.js"
        commonJSName "React",
      "org.webjars.npm" % "react-dom" % "18.2.0"
        / "umd/react-dom.development.js"
        minified "umd/react-dom.production.min.js"
        dependsOn "umd/react.development.js"
        commonJSName "ReactDOM",
      "org.webjars.npm" % "react-dom" % "18.2.0"
        / "umd/react-dom-server.browser.development.js"
        minified "umd/react-dom-server.browser.production.min.js"
        dependsOn "umd/react-dom.development.js"
        commonJSName "ReactDOMServer",
    ),
  )
Global / onChangedBuildSource := ReloadOnSourceChanges
