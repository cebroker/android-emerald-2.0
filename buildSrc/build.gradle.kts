plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.10"
    `java-gradle-plugin`
}

repositories {
    jcenter()
    google()
    mavenCentral()
}

dependencies{
    implementation(kotlin("stdlib-jdk8"))
}