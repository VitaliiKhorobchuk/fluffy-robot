plugins {
    id("de.fayard.refreshVersions") version "0.30.2"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Recepier"
include("app")
include(":domain")
include(":data")
