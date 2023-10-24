plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply(from = "$rootDir/gradle/domain.gradle")

android {
    namespace = "com.project.login.domain"
}