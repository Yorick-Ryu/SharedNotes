plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-resources")
}

group = "com.yorick"
version = "1.0-SNAPSHOT"

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
    sourceSets {

        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }

        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.animation)
                api(compose.material3)
                api(compose.material)
                api(compose.materialIconsExtended)
                api(compose.foundation)
                implementation("com.mikepenz:multiplatform-markdown-renderer:0.6.1")
                api("moe.tlaster:precompose:1.3.13")
                api("dev.icerock.moko:resources:0.20.1")
            }
        }

        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.12.0")
                implementation("androidx.window:window:1.1.0")
                implementation("com.google.accompanist:accompanist-adaptive:0.28.0")
                implementation("androidx.navigation:navigation-compose:2.7.5")
                implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0-beta01")
                implementation("androidx.compose.material3:material3:1.2.0-alpha10")
                implementation("androidx.compose.material:material-icons-extended:1.6.0-alpha08")
                implementation("androidx.compose.material3:material3-window-size-class:1.2.0-alpha10")
            }
        }

        val desktopMain by getting {
            dependencies {
                api(compose.preview)
            }
        }

    }
}

android {
    compileSdk = 34
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.yorick.sharednotes"
}