plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltAndroid)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)

    //Ktx extensions
    implementation(Libs.fragmentKtx)

    // Kotlin
    implementation(kotlin("bom"))
    implementation(kotlin(Libs.kotlinStdlib))

    // UI
    implementation(Libs.material)
    implementation(Libs.constraintLayout)

    // Firebase
    implementation(enforcedPlatform(Libs.firebaseBom))
    implementation(Libs.firebaseAnalyticsKtx)
    implementation(Libs.playServicesAds)

    // DI
    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltCompiler)

    // Arch components
    implementation(Libs.workRuntimeKtx)
    implementation(Libs.lifecycleViewModelKtx)
    implementation(Libs.lifecycleLivedataKtx)
    implementation(Libs.lifecycleViewModelSavedState)

    // Room
    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)

    // Coroutines
    implementation(Libs.kotlinxCoroutinesAndroid)
    implementation(Libs.kotlinxCoroutinesCore)

    // Glide
    implementation(Libs.glide)
    kapt(Libs.glideCompiler)

    // Utils
    implementation(Libs.timber)
    implementation(Libs.logger)
    implementation(Libs.gson)

    // Test
    testImplementation(Libs.junit)
}

hilt {
    enableAggregatingTask = true
}