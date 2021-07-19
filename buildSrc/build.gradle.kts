plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.10"
    `java-gradle-plugin`
}

repositories {
    jcenter()
}

dependencies{
    implementation(kotlin("stdlib-jdk8"))
}