apply(plugin = "maven-publish")

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(components.findByName("android"))
}

configure<PublishingExtension> {
    publications {
        with(PublishConstants) {
            create<MavenPublication>(PUBLICATION_NAME) {
                run {
                    groupId = ARTIFACT_GROUP
                    artifactId = ARTIFACT_NAME
                    version = VERSION
                    from(components.findByName("android"))
                    artifact(sourcesJar)
                    artifact("$buildDir/outputs/aar/app-release.aar")
                    pom {
                        name.set(ARTIFACT_NAME)
                        description.set(POM_DESCRIPTION)
                        url.set(POM_URL)
                        licenses {
                            license {
                                name.set(LICENSE_NAME)
                                url.set(LICENSE_URL)
                            }
                        }
                        developers {
                            developer {
                                id.set(DEVELOPER)
                                name.set(DEVELOPER_NAME)
                            }
                        }
                    }
                }
            }
        }
    }
}