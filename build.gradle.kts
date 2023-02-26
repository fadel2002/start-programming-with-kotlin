plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "com.dicoding.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
}

