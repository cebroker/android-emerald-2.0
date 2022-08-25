object Versions {
    const val gradlePlugin = "7.0.0"
    const val kotlin = "1.6.10"
    const val compose = "1.1.0"
    const val jUnit = "4.13.2"
    const val extJUnit = "1.1.3"
    const val espressoCore = "3.4.0"
    const val activityCompose = "1.3.0"
    const val material = "1.4.0"
    const val navigation = "2.4.0-alpha05"
    const val testCore = "1.4.0"
    const val kotlinReflect = "1.7.10"
}

object Dependencies {

    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val kotlinReflect by lazy {"org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinReflect}"}
    val material by lazy { "com.google.android.material:material:${Versions.material}" }

    object Compose {
        val ui by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
        val material by lazy { "androidx.compose.material:material:${Versions.compose}" }
        val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
        val activity by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
        val navigation by lazy { "androidx.navigation:navigation-compose:${Versions.navigation}" }
    }

    object Test {
        val junit by lazy { "junit:junit:${Versions.jUnit}" }
        val extJUnit by lazy { "androidx.test.ext:junit:${Versions.extJUnit}" }
        val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
        val compose by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
        val composeManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }
        val composeUITest by lazy { "androidx.compose.ui:ui-test:${Versions.compose}" }
        val testCore by lazy { "androidx.test:core:${Versions.testCore}" }
        val testCoreKtx by lazy { "androidx.test:core-ktx:${Versions.testCore}" }
    }
}

object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}
