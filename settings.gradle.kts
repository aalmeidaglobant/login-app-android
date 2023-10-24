@file:Suppress("UnstableApiUsage")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "login-app"
include(":app")
include(":core")
include(":design-system")
include(":features")
include(":features:login")
include(":features:login:data")
include(":features:login:domain")
include(":features:login:presentation")
include(":features:home")
include(":features:home:data")
include(":features:home:domain")
include(":features:home:presentation")
