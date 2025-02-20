// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	alias(libs.plugins.android.application) apply false
	alias(libs.plugins.kotlin.android) apply false
}

dependencies {
	implementation("com.google.android.material:material:1.6.0")
	implementation("androidx.compose.ui:ui:1.3.0")
	implementation("androidx.compose.material:material:1.3.0")
	implementation("androidx.compose.ui:ui-tooling-preview:1.3.0")
	implementation("androidx.navigation:navigation-compose:2.5.0")
	implementation("com.google.dagger:hilt-android:2.42")
	kapt("com.google.dagger:hilt-compiler:2.42")
}