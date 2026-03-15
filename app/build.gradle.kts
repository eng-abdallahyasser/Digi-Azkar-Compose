plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
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
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
// Optional: Lifecycle utilities for Compose (collectAsStateWithLifecycle)
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
// Navigation Compose (if you need ViewModel scoped to a NavGraph)
    implementation(libs.androidx.navigation)
    // Retrofit core
    implementation("com.squareup.retrofit2:retrofit:3.0.0")

    implementation("com.squareup.retrofit2:converter-moshi:3.0.0")

    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")

    implementation ("org.threeten:threetenbp:1.6.9:no-tzdb")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation(libs.kotlinx.serialization.json)
}