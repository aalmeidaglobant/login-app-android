plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.androidx.safe.args.kotlin)
}

android {
    namespace = "com.project.application"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.project.application"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    kapt(libs.dagger.hilt.compiler)
    implementation(libs.dagger.hilt.android)

    implementation(libs.bundles.presentation.module)

    implementation(projects.core)
    implementation(projects.designSystem)

    implementation(projects.features.login.domain)
    implementation(projects.features.login.presentation)
    implementation(projects.features.login.data)

    implementation(projects.features.home.domain)
    implementation(projects.features.home.presentation)
    implementation(projects.features.home.data)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}