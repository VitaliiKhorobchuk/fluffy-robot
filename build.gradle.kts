// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.4.0")
        classpath(Dependencies.kotlin_gradle_plugin)
        classpath(Dependencies.hiltAndroidGradlePlugin)
        classpath(Dependencies.navigationSafeArgs)
    }
}

