plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply(from = "$rootDir/gradle/core.gradle")

android {
    namespace = "com.project.core"
}