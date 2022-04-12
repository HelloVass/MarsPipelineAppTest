buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // agp
        classpath("com.android.tools.build:gradle:4.2.2")
        // kotlin gradle plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}