plugins {
    java
}

group = "com.engine.external.project"
version = "1.0"

subprojects {
    plugins.apply("java")

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation("junit", "junit", "4.12")
    }


}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}