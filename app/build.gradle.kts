plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("com.bytedance.mars.mars-gradle-plugin")
}

android {
    compileSdkVersion(32)

    defaultConfig {
        applicationId = "info.hellovass.mars"
        minSdkVersion(21)
        targetSdkVersion(32)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("release") {
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

fun getDeps(): Map<String, String?> {
    val ext = rootProject.extensions["veMarsExt"] as? com.bytedance.mars.veMarsExt
        ?: return emptyMap()
    return ext.deps.toMap()
}

dependencies {
    val deps = getDeps()
    // material
    implementation(requireNotNull(deps["material"]))
    // appcompat
    implementation(requireNotNull(deps["appcompat"]))
    // test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation(requireNotNull(deps["espresso_core"]))
}