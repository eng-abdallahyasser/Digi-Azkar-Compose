plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.abdallahyasser.digiazkarcompose"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.abdallahyasser.digiazkarcompose"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.foundation)
    // Standard Coroutines library for common logic
    implementation(libs.kotlinx.coroutines.core)

    // Android-specific Coroutines (gives you Dispatchers.Main and UI support)
    implementation(libs.kotlinx.coroutines.android)

    // Lifecycle Scopes (ViewModelScope, LifecycleScope) - Highly Recommended
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx.v270)
    // ViewModel for Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
// Optional: Lifecycle utilities for Compose (collectAsStateWithLifecycle)
    implementation(libs.androidx.lifecycle.runtime.compose)
// Navigation Compose (if you need ViewModel scoped to a NavGraph)
    implementation(libs.androidx.navigation)
    // Retrofit core
    implementation(libs.retrofit)

    implementation(libs.converter.moshi)

    implementation(libs.moshi.kotlin)

    implementation (libs.threetenbp)

    implementation(libs.hilt.android)
    ksp(libs.dagger.hilt.android.compiler)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation(libs.kotlinx.serialization.json)
}