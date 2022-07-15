import com.bytedance.mars.veMarsExt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.bytedance.mars.mars-gradle-plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "info.hellovass.mars"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        @Suppress("UNUSED_VARIABLE")
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

val user: String by resolveDependencies()

fun resolveDependencies(): Map<String, String?> {
    val ext = rootProject.extensions["veMarsExt"] as? veMarsExt
        ?: return emptyMap()
    return ext.deps.toMap()
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    implementation(user)
}