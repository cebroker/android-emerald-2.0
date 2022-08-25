plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = DefaultConfig.compileSdk
    buildToolsVersion = DefaultConfig.buildToolsVersion

    defaultConfig {
        applicationId = DefaultConfig.applicationId
        minSdk = DefaultConfig.minSdk
        targetSdk = DefaultConfig.targetSdk
        versionCode = DefaultConfig.versionCode
        versionName = DefaultConfig.versionName
        testInstrumentationRunner = DefaultConfig.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = DefaultConfig.javaVersion
        targetCompatibility = DefaultConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = DefaultConfig.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(project(mapOf("path" to ":app")))

    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.navigation)

    testImplementation(Dependencies.Test.junit)

    androidTestImplementation(Dependencies.Test.extJUnit)
    androidTestImplementation(Dependencies.Test.espressoCore)
}