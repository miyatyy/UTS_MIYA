plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "id.antasari.uts_mp_UTS_MIYA"
    compileSdk = 34

    defaultConfig {
        applicationId = "id.antasari.uts_mp_UTS_MIYA"
        minSdk = 24
        targetSdk = 34
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        // ✅ Pastikan cocok dengan Kotlin 1.9.10
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // ✅ Opsional tapi disarankan agar IDE tahu versi Compose
    packaging {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    // --- Core Compose ---
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.ui:ui:1.6.8")
    implementation("androidx.compose.material:material:1.6.8")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.8")

    // --- Navigation Compose ---
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // --- Lifecycle (optional tapi direkomendasikan) ---
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")

    // --- Material 3 (untuk Theme.Material3.DayNight.NoActionBar) ---
    implementation("androidx.compose.material3:material3:1.2.1")

    // --- Material Components (untuk Theme.MaterialComponents.DayNight.NoActionBar) ---
    implementation("com.google.android.material:material:1.12.0")

    // --- Test (default Android Studio) ---
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.8")
    implementation("androidx.compose.material:material-icons-extended:1.6.8")

}
