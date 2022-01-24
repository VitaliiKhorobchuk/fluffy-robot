/**
 * Find which updates are available by running
 *     $ ./gradlew refreshVersions
 * And edit the file `versions.properties`
 *
 * See https://github.com/jmfayard/refreshVersions
 */
object Libs {
    const val appCompat: String = "androidx.appcompat:appcompat:_"

    const val material: String = "com.google.android.material:material:_"

    const val constraintLayout: String =
        "androidx.constraintlayout:constraintlayout:_"

    const val coreKtx: String = "androidx.core:core-ktx:_"

    const val fragmentKtx: String = "androidx.fragment:fragment-ktx:_"

    const val lifecycleLivedataKtx: String =
        "androidx.lifecycle:lifecycle-livedata-ktx:_"
    const val lifecycleViewModelKtx: String =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:_"
    const val lifecycleViewModelSavedState: String =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:_"

    const val roomRuntime: String = "androidx.room:room-runtime:_"
    const val roomCompiler: String = "androidx.room:room-compiler:_"
    const val roomKtx: String = "androidx.room:room-ktx:_"

    const val workRuntimeKtx: String = "androidx.work:work-runtime-ktx:_"

    const val hiltAndroid: String = "com.google.dagger:hilt-android:_"
    const val hiltCompiler: String = "com.google.dagger:hilt-compiler:_"
    const val hiltViewModel: String = "androidx.hilt:hilt-lifecycle-viewmodel:_"
    const val hiltViewModelCompiler: String = "androidx.hilt:hilt-compiler:_"

    const val firebaseBom: String = "com.google.firebase:firebase-bom:_"
    const val firebaseAnalyticsKtx: String = "com.google.firebase:firebase-analytics-ktx"
    const val playServicesAds: String =
        "com.google.android.gms:play-services-ads:_"

    const val kotlinxCoroutinesAndroid: String =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:_"
    const val kotlinxCoroutinesCore: String =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:_"

    const val kotlinStdlib: String = "stdlib-jdk8"

    const val junit: String = "junit:junit:_"

    const val glide: String = "com.github.bumptech.glide:glide:_"
    const val glideCompiler: String = "com.github.bumptech.glide:compiler:_"

    const val navigationFragment: String = "androidx.navigation:navigation-fragment-ktx:_"
    const val navigationUi: String = "androidx.navigation:navigation-ui-ktx:_"

    const val timber: String = "com.jakewharton.timber:timber:_"
    const val logger: String = "com.orhanobut:logger:_"

    const val gson: String = "com.google.code.gson:gson:_"
}
