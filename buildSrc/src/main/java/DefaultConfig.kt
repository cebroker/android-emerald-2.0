import org.gradle.api.JavaVersion

object DefaultConfig {
    const val compileSdk = 31
    const val buildToolsVersion = "31.0.0"
    const val applicationId = "co.condorlabs.emerald"
    const val minSdk = 21
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val jvmTarget = "1.8"
    val javaVersion = JavaVersion.VERSION_1_8
}