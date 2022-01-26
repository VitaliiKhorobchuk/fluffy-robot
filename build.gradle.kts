// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
//        classpath(Android.tools.build.gradlePlugin)
        classpath(Dependencies.gradle)
        classpath(Dependencies.kotlin_gradle_plugin)
        classpath(Dependencies.hiltAndroidGradlePlugin)
        classpath(Dependencies.navigationSafeArgs)
    }
}