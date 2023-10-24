plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply(from = "$rootDir/gradle/presentation.gradle")

android {
    namespace = "com.project.home.presentation"
}

dependencies {
    implementation(projects.features.home.domain)
}