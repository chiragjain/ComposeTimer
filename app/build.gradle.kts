plugins {
    id("com.android.application")
    kotlin("kapt")
    kotlin("android")
    id("dagger.hilt.android.plugin")
}

android {

    compileSdk = 31

    defaultConfig {
        applicationId ="com.learn.timer"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName  = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility =JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {

    implementation(AndroidX.core)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.fragmentKtx)
    implementation(AndroidX.lifecycleRuntime)
    implementation(Google.materialDesign)

    implementation(Compose.ui)
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.material)
    implementation(Compose.materialIconCore)
    implementation(Compose.materialIconExtended)
    implementation(Compose.activity)
    implementation(Compose.constraintLayout)
    implementation(Compose.activityCompose)
    implementation(Compose.viewModel)
    implementation(Compose.runtimeLiveData)

    implementation(Coil.compose)
    implementation(Accompanist.insets)
    implementation(Accompanist.systemuicontroller)

    implementation(Google.Hilt.android)
    kapt(Google.Hilt.compiler)

    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.junitExt)
    androidTestImplementation(Compose.uiTestJunit4)
    androidTestImplementation(TestLibs.esspressoCore)

}