plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply(from = "$rootDir/gradle/data.gradle")

android {
    namespace = "com.project.home.data"
}

dependencies {
    implementation(projects.features.home.domain)
}