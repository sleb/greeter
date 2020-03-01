import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    kotlin("jvm") version "1.3.61"
    application
}

repositories {
    jcenter()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform(kotlin("bom")))

    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))

    implementation("io.javalin:javalin:3.7.0")

    runtimeOnly("org.slf4j:slf4j-simple:1.7.28")

    // Use the Kotlin test library.
    testImplementation(kotlin("test"))

    // Use the Kotlin JUnit integration.
    testImplementation(kotlin("test-junit"))
}

application {
    mainClassName = "greeter.AppKt"
}

tasks {
    test {
        testLogging {
            events = setOf(PASSED, SKIPPED, FAILED)
        }
    }
}
