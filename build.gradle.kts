buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
        classpath(BuildPlugins.gradleMaven)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}