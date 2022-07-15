plugins {
    id("com.android.application") version "7.0.4" apply false
    id("com.android.library") version "7.0.4" apply false
    id("org.jetbrains.kotlin.android") version "1.5.31" apply false
}

val clean by tasks.registering(Delete::class) {
    delete(rootProject.buildDir)
}