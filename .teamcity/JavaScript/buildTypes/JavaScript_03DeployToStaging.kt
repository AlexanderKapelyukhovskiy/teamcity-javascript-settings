package JavaScript.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object JavaScript_03DeployToStaging : BuildType({
    uuid = "91aaccbb-6fef-446a-ba2f-bfe1a64902e8"
    extId = "JavaScript_03DeployToStaging"
    name = "03. Deploy To Staging"

    vcs {
        root(JavaScript.vcsRoots.JavaScript_HttpsGithubComAlexanderKapelyukhovskiyTeamcityCourseCards)

    }
    steps {
        script {
            name = "IIE Deploy"
            id = "RUNNER_6"
            scriptContent = """
                rmdir /S /Q \inetpub\wwwroot
                xcopy /S /I /Y app \inetpub\wwwroot\
            """
        }
    }

    dependencies {
        dependency(JavaScript.buildTypes.JavaScript_02Chrome) {
            snapshot {
            }
        }
        dependency(JavaScript.buildTypes.JavaScript_02Firefox) {
            snapshot {
            }
        }
    }
    triggers {
        vcs {
            id = "vcsTrigger"
        }
    }
})
