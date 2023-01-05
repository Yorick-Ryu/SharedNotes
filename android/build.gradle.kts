plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group "com.yorick"
version "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("com.google.accompanist:accompanist-adaptive:0.28.0")
    implementation("androidx.compose.material3:material3:1.1.0-alpha03")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.0-alpha03")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.yorick.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}