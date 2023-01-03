plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "me.hechfx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://repo.perfectdreams.net/")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    implementation("org.mongodb:mongodb-driver:3.12.10")

    implementation("net.perfectdreams.exposedpowerutils:postgres-java-time:1.0.0")

    implementation("org.jetbrains.exposed:exposed-java-time:0.37.3")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("org.jetbrains.exposed:exposed-core:0.37.3")
    implementation("org.jetbrains.exposed:exposed-dao:0.37.3")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.37.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    shadowJar {
        manifest {
            attributes["Main-Class"] = "me.hechfx.project.MainKt"
        }
    }
}