plugins {
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.dagger.hilt.android).apply(false)
    alias(libs.plugins.kotlin.kapt).apply(false)
    alias(libs.plugins.androidx.safe.args.kotlin).apply(false)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}