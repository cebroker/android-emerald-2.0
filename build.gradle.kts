buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
        classpath(BuildPlugins.bintray)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}