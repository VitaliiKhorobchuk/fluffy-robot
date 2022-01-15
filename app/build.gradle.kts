plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.sixoutoften.recepier"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName ="1.0"

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

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")

    // UI
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")

    // Firebase
    implementation(enforcedPlatform("com.google.firebase:firebase-bom:29.0.3"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.android.gms:play-services-ads:20.5.0")


    // DI
    val hiltVersion = "2.38.1"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

    //Arch components
    implementation("androidx.work:work-runtime-ktx:2.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")

    val lifecycleVersion = "2.4.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion")

    //Room
    val roomVersion = "2.4.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")

    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}