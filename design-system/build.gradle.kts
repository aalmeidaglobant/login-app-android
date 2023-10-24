plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply(from = "$rootDir/gradle/design-system.gradle")

android {
    namespace = "com.project.design_system"
}