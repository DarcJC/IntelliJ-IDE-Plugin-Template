import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.6.10-RC"
    id("org.jetbrains.intellij") version "1.3.1"
}

group = "pro.darc.pigeon"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

intellij {
    version.set("2021.2.2")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<org.jetbrains.intellij.tasks.BuildSearchableOptionsTask>() {
    enabled = true
}

tasks.withType<org.jetbrains.intellij.tasks.PatchPluginXmlTask>() {
    version.set(project.version.toString())
    sinceBuild.set("211")
}
