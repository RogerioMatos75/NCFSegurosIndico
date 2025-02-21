// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	alias(libs.plugins.android.application) apply false
	alias(libs.plugins.kotlin.android) apply false
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
	id("kotlin-kapt")
	id("dagger.hilt.android.plugin")
}

dependencies {
	implementation("com.google.android.material:material:1.6.0")
	implementation("androidx.compose.ui:ui:1.3.0")
	implementation("androidx.compose.material:material:1.3.0")
	implementation("androidx.compose.ui:ui-tooling-preview:1.3.0")
	implementation("androidx.navigation:navigation-compose:2.5.0")
	implementation("com.google.dagger:hilt-android:2.42")
	kapt("com.google.dagger:hilt-compiler:2.42")
	testImplementation("junit:junit:4.13.2")
	testImplementation("org.mockito:mockito-core:3.12.4")
	testImplementation("org.mockito:mockito-inline:3.12.4")
	androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.0")
	androidTestImplementation("androidx.compose.ui:ui-test-manifest:1.3.0")
}