buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
