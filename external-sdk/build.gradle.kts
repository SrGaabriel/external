plugins {
    java
    kotlin("jvm") version "1.3.72"
}

group = "com.engine.external.project"
version = "1.0-SNAPSHOT"

plugins.apply("kotlin")

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