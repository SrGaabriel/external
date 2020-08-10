plugins {
    java
    kotlin("jvm") version "1.3.72"
}

group = "com.engine.external.project"
version = "1.0-SNAPSHOT"

plugins.apply("kotlin")

repositories {
    mavenCentral()
}

dependencies {
    api(project(":external-api"))

    implementation("com.mojang:authlib:1.5.19-SNAPSHOT")

    implementation("io.netty:netty-all:4.1.51.Final")

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