import groovy.lang.Closure

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "D3M"
include(":app")
includeBuild("../node_modules/@react-native/gradle-plugin")

val nodeModulesDir = file("../node_modules")

apply(from = nodeModulesDir.resolve("@react-native-community/cli-platform-android/native_modules.gradle"));

val applyNativeModulesAppBuildGradle = extra.get("applyNativeModulesSettingsGradle") as Closure<Any>;


applyNativeModulesAppBuildGradle(settings)