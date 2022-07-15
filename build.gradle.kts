buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://artifact.bytedance.com/repository/Volcengine/") }
    }
    dependencies {
        // agp
        classpath("com.android.tools.build:gradle:4.2.2")
        // kotlin gradle plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        //
        classpath("com.bytedance.mars:mars-gradle-plugin:1.0.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://artifact.bytedance.com/repository/Volcengine/") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}