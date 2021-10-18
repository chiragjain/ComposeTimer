@file:Suppress("SpellCheckingInspection")

object BuildPlugins {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
}

object Hotstar {
    const val buildConfigPlugin = "in.startv.hotstar:android-build-config-plugin:${Versions.Hotstar.buildConfigPlugin}"
    const val iconFontPlugin = "com.startv.hotstar:icon-font-plugin:${Versions.Hotstar.iconFontPlugin}"
    const val networkUtils = "com.hotstar:network-utils-lib-android:${Versions.Hotstar.networkUtils}"
    const val stringStoreApi = "com.hotstar:string-store-lib-api-android:${Versions.Hotstar.stringStore}"
    const val stringStore = "com.hotstar:string-store-lib-android:${Versions.Hotstar.stringStore}"
    const val bffProtobuf = "com.hotstar.protobuf.bff:android-bff-protobuf-data-model:${Versions.Hotstar.bffProtobuf}"
    const val compass = "com.hotstar:compass:${Versions.Hotstar.compass}"
}

object Kotlin {
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.core}"
    const val reflection = "org.jetbrains.kotlin:kotlin-reflect:${Versions.Kotlin.core}"
    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.andoridCoroutines}"
    }
}

object AndroidX {
    const val core = "androidx.core:core-ktx:${Versions.AndroidX.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
    const val palette = "androidx.palette:palette-ktx:${Versions.AndroidX.palette}"
    const val testRules = "androidx.test:rules:${Versions.AndroidX.testRules}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycle}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.AndroidX.fragmentKtx}"
}

object Compose {
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val materialIconCore = "androidx.compose.material:material-icons-core:${Versions.compose}"
    const val materialIconExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val activity = "androidx.activity:activity-compose:${Versions.Compose.activity}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.viewModel}"
    const val paging = "androidx.paging:paging-compose:${Versions.Compose.paging}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.constraintLayout}"
    const val lottie = "com.airbnb.android:lottie-compose:${Versions.Compose.lottie}"
    const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha08"
}

object Google {
    const val materialDesign = "com.google.android.material:material:${Versions.Google.materialDesign}"
    object Hilt {
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Google.hilt}"
        const val android = "com.google.dagger:hilt-android:${Versions.Google.hilt}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.Google.hilt}"
    }
}

object Square {
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.Square.leakcanary}"
}

object Coil {
    const val compose = "io.coil-kt:coil-compose:${Versions.coil}"
    const val gif = "io.coil-kt:coil-gif:${Versions.coil}"
}
object Accompanist {
    const val insets = "com.google.accompanist:accompanist-insets:${Versions.Accompanist.insetsVersion}"
    const val systemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:${Versions.Accompanist.systemuicontrollerVersion}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.TestLibs.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.TestLibs.extJunit}"
    const val esspressoCore = "androidx.test.espresso:espresso-core:${Versions.TestLibs.espressoCore}"
    const val shots = "com.karumi:shot:${Versions.TestLibs.shots}"
    const val corotinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.TestLibs.coroutinesTest}"
    const val coreTest = "androidx.arch.core:core-testing:${Versions.TestLibs.coreTest}"
}