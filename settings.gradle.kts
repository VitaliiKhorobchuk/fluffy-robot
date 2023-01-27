plugins {
    id("de.fayard.refreshVersions") version "0.30.2"
////                            # available:"0.40.0"
////                            # available:"0.40.1"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Recepier"
include(":domain")
include(":data")
include(":app")
