plugins {
    java
}

group = "com.engine.external.project"
version = "1.0"

dependencies {
    testImplementation("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}