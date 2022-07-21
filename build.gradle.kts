buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

plugins {

    /**
     * You should use `apply false` in the top-level build.gradle file
     * to add a Gradle plugin as a build dependency, but not apply it to the
     * current (root) project. You should not use `apply false` in sub-projects.
     * For more information, see
     * Applying external plugins with same version to subprojects.
     */

    id("com.android.application") version Versions.gradlePlugin apply false
    id("com.android.library") version Versions.gradlePlugin apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlin apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}