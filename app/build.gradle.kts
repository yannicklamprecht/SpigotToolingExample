plugins {
    java
    `maven-publish`
    // id("com.github.johnrengelman.shadow") version "7.0.0"
    id("com.github.yannicklamprecht.spigot.tools") version "1.0.1"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

    maven {
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot:1.17-R0.1-SNAPSHOT:remapped-mojang")
}

group = "com.github.yannicklamprecht.spigot.tooling.example"
version = "1.0-SNAPSHOT"
description = "SpigotToolingExample"
java.sourceCompatibility = JavaVersion.VERSION_16

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }

    spigotTools {
        mojangMapped.set(true)
        version.set("1.17")
        outputClassifier.set("spigot-mapped")
    }

    processResources {
        from(sourceSets.main.get().resources.srcDirs) {
            filesMatching("plugin.yml") {
                expand(
                    "version" to project.version
                )
            }
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }
    }
}

