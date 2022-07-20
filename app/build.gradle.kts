import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.jfrog.bintray")
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
}

val properties: Properties = Properties()
properties.load(FileInputStream("local.properties"))

bintray {
    user = properties.getProperty(BintrayConstants.BINTRAY_USER_KEY)
    key = properties.getProperty(BintrayConstants.BINTRAY_PASSWORD_KEY)
    publish = true

    setPublications(LibraryConstants.PUBLICATION_NAME)

    pkg.apply {
        repo = BintrayConstants.REPO_NAME
        name = LibraryConstants.ARTIFACT_GROUP
        userOrg = BintrayConstants.USER_ORG
        githubRepo = BintrayConstants.GITHUB_URL
        vcsUrl = BintrayConstants.GITHUB_URL
        description = LibraryConstants.POM_DESCRIPTION
        setLabels("kotlin")
        setLicenses(BintrayConstants.LICENSE)
        desc = LibraryConstants.POM_DESCRIPTION
        websiteUrl = BintrayConstants.GITHUB_URL
        issueTrackerUrl = BintrayConstants.GITHUB_URL
        githubReleaseNotesFile = BintrayConstants.GITHUB_URL

        version.apply {
            name = LibraryConstants.VERSION
            desc = LibraryConstants.POM_DESCRIPTION
            vcsTag = "v${LibraryConstants.VERSION}"
        }
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
}