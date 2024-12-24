plugins {
    kotlin("jvm") version "2.0.21"
    id("io.qameta.allure") version "2.12.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val allureVersion by extra("2.29.1")
val junitVersion by extra("5.11.4")
val aspectjVersion by extra("1.9.22.1")

dependencies {
    // General
    implementation("org.aspectj:aspectjweaver:$aspectjVersion")

    // Playwright
    implementation("com.microsoft.playwright:playwright:1.49.0")

    // JUnit 5
    implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")

    // Assertions
    implementation("io.kotest:kotest-assertions-core:5.9.1")

    // Allure
    implementation("io.qameta.allure:allure-junit5:$allureVersion")
}

allure {
    version = allureVersion
    adapter.autoconfigure = true
    adapter.aspectjVersion = aspectjVersion
    adapter.frameworks.junit5.adapterVersion = allureVersion
}

tasks.test {
    jvmArgs("-noverify")

    useJUnitPlatform {
        if (System.getProperty("TAGS") != null) {
            includeTags(System.getProperty("TAGS"))
        }
    }
    dependsOn("cleanTest")
    testLogging {
        events("passed", "skipped", "failed")
    }

    //Pass system properties into JVM with tests
    systemProperties(systemProperties)
}
kotlin {
    jvmToolchain(11)
}