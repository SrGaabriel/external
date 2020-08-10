plugins {
    java
    kotlin("jvm") version "1.3.72"
}

group = "com.engine.external.project"
version = "1.0-SNAPSHOT"

plugins.apply("kotlin")

repositories {
    mavenCentral()

    maven("https://libraries.minecraft.net")
    maven("https://mvnrepository.com/artifact/io.netty/netty-all")
}

dependencies {
    api(project(":external-api"))

    implementation("com.mojang:authlib:1.5.21")
    implementation("io.netty:netty-all:4.1.51.Final")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")

    implementation(kotlin("stdlib-jdk8"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}