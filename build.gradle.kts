plugins {
    java
}

group = "com.engine.external.project"
version = "1.0"

subprojects {
    plugins.apply("java")

    repositories {
        jcenter()

        mavenCentral()

        maven("http://clojars.org/repo/")
    }

    dependencies {
        testImplementation("junit", "junit", "4.12")

        implementation("kryonet:kryonet:2.21")
        
        implementation("com.google.code.gson:gson:2.8.6")

        implementation("org.kodein.di:kodein-di:7.0.0")

        implementation("com.github.luben:zstd-jni:1.4.5-6")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}