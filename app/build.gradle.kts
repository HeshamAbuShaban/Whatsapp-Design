plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //..
    // for navigation safe args
    id("androidx.navigation.safeargs")
    // KSP Plugins
    id("com.google.devtools.ksp")
    //..DaggerHilt
    id("com.google.dagger.hilt.android")
    // Kapt
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "dev.training.whatsapp_design"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.training.whatsapp_design"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_20
        targetCompatibility = JavaVersion.VERSION_20
    }
    kotlinOptions {
        jvmTarget = "20"
    }
}

dependencies {

    // AndroidX
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Material
    implementation("com.google.android.material:material:1.9.0")
    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // Navigation
    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.3")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    ksp("com.github.bumptech.glide:compiler:4.16.0")

    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    ksp("com.google.dagger:hilt-compiler:2.48")

    // Splash API
    implementation("androidx.core:core-splashscreen:1.0.1")

    // sdp ssp
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.intuit.ssp:ssp-android:1.1.0")

    // Shimmer PlaceHolders for the Data that comes from the server
    implementation("com.facebook.shimmer:shimmer:0.5.0")

}