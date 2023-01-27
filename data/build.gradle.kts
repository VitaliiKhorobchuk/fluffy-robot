
plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {


        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    namespace = "com.sixoutoften.data"
}

dependencies {
    implementation(project(":domain"))
    implementation(Libs.coreKtx)

    // DI
    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltCompiler)

    // Room
    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)

    implementation(Libs.gson)

    // Test
    testImplementation(Libs.junit)
}