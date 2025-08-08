pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.kikugie.dev/snapshots") { name = "KikuGie Snapshots" }
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.7.6"
}

stonecutter {
    create(rootProject) {
        versions("1.18.2", "1.19", "1.19.1", "1.21.8")
        vcsVersion = "1.21.8"
    }
}

rootProject.name = "WCIFS"