/*
 * This file was generated by the Gradle 'init' task.
 */

rootProject.name = "SpigotToolingExample"
include("app")

pluginManagement {
    repositories {
        // mavenLocal()
        maven {
            name = "eldonexus"
            // url = uri("https://eldonexus.de/repository/maven-snapshots/")
            url = uri("https://eldonexus.de/repository/maven-releases/")
        }
        gradlePluginPortal()
    }
}