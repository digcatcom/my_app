import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "my_app"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      // Add your project dependencies here,
	"postgresql" % "postgresql" % "8.4-702.jdbc4"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
