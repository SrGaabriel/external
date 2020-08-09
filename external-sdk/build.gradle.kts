plugins {
    java
    kotlin("jvm") version "1.3.72"
}

group = "com.engine.external.project"
version = "1.0-SNAPSHOT"

plugins.apply("kotlin")

repositories {
    google()
    maven("https://dl.bintray.com/kodein-framework/kodein-dev")
}

dependencies {
    api(project(":external-api"))

    implementation(kotlin("stdlib-jdk8"))
    implementation("org.kodein.di:kodein-di:7.0.0")
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