import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    application
}

group = "xyz.lightning-mc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.purpurmc.org/snapshots")
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("org.purpurmc.purpur:purpur-api:1.18.2-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}