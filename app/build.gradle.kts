plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
}
apply {
    from("../install.gradle.kts")
}

android {
    compileSdk = DefaultConfig.compileSdk
    buildToolsVersion = DefaultConfig.buildToolsVersion

    defaultConfig {
        minSdk = DefaultConfig.minSdk
        targetSdk = DefaultConfig.targetSdk
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
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {
    api(Dependencies.material)
    api(Dependencies.Compose.ui)
    api(Dependencies.Compose.material)
    api(Dependencies.Compose.uiTooling) {
        version {
            strictly("1.0.0-beta09")
        }
    }

    androidTestImplementation(Dependencies.Test.composeUITest)
    androidTestImplementation(Dependencies.Test.compose)
    debugImplementation(Dependencies.Test.composeManifest)

    androidTestImplementation(Dependencies.Test.testCore)
    androidTestImplementation(Dependencies.Test.testCoreKtx)

    implementation(Dependencies.kotlinReflect)
}