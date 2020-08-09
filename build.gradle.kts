plugins {
    java
}

group = "com.engine.external.project"
version = "1.0"

subprojects {
    plugins.apply("java")

    repositories {
        mavenCentral()

        maven("https://repo.spring.io/milestone")
    }

    dependencies {
        testImplementation("junit", "junit", "4.12")

        implementation("io.projectreactor:reactor-core:3.4.0-M1")
    }


}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}