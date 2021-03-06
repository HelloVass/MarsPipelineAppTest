rootProject.name = "MarsPipelineAppTest"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://artifact.bytedance.com/repository/Volcengine/") }
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application",
                "com.android.library" ->
                    useModule("com.android.tools.build:gradle:4.2.2")
                "com.bytedance.mars.mars-gradle-plugin" -> {
                    useModule("com.bytedance.mars:mars-gradle-plugin:1.0.2")
                }
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven("https://repo.rdc.aliyun.com/repository/139280-release-is28wB/") {
            credentials {
                username = "bjO81N"
                password = "CUUi8rlOB1"
            }
        }
    }
}

include(":app")
