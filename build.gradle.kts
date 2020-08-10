plugins {
    java
}

group = "com.engine.external.project"
version = "1.0"

subprojects {
    plugins.apply("java")

    repositories {
        mavenCentral()

        jcenter()

        maven("https://repo.spring.io/milestone")
    }

    dependencies {
        testImplementation("junit", "junit", "4.12")

        implementation("io.projectreactor:reactor-core:3.4.0-M1")

        implementation("org.slf4j:slf4j-api:1.7.29")

        implementation("org.kodein.di:kodein-di:7.0.0")

        implementation("ch.qos.logback:logback-classic:0.9.26")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}