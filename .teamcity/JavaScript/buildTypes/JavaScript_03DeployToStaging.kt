package JavaScript.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*

object JavaScript_03DeployToStaging : BuildType({
    uuid = "91aaccbb-6fef-446a-ba2f-bfe1a64902e8"
    extId = "JavaScript_03DeployToStaging"
    name = "03. Deploy To Staging"

    vcs {
        root(JavaScript.vcsRoots.JavaScript_HttpsGithubComAlexanderKapelyukhovskiyTeamcityCourseCards)

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
        dependency(JavaScript.buildTypes.JavaScript_02IE) {
            snapshot {
            }
        }
    }
})
