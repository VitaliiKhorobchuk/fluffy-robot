    plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltAndroid)
    id(Plugins.navigationSafeArgs)
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

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {
    implementation(project(Projects.domain))
    implementation(project(Projects.data))

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
    implementation(Libs.hiltViewModel)
    kapt(Libs.hiltCompiler)
    kapt(Libs.hiltViewModelCompiler)

    // Arch components
    implementation(Libs.workRuntimeKtx)
    implementation(Libs.lifecycleViewModelKtx)
    implementation(Libs.lifecycleViewModelSavedState)

    // Navigation
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)

    // Coroutines
    implementation(Libs.kotlinxCoroutinesAndroid)
    implementation(Libs.kotlinxCoroutinesCore)

    // Glide
    implementation(Libs.glide)
    kapt(Libs.glideCompiler)

    // Utils
    implementation(Libs.timber)
    implementation(Libs.logger)

    // Compose
    implementation(Libs.composeUi)
    implementation(Libs.composeUiTooling)
    implementation(Libs.composeActivity)
    implementation(Libs.composeFoundation)
    implementation(Libs.composeMaterial3)

    // Test
    testImplementation(Libs.junit)
}

hilt {
    enableAggregatingTask = true
}