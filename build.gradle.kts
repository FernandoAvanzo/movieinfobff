val kotlinLanguageVersion: String by project
val koinVersion: String by project
val ktorVersion: String by project
val kotestVersion: String by project
val kotlinLoggingJvmVersion: String by project
val kodeinVersion: String by project
val exposedVersion: String by project
val mockkVersion: String by project
val swaggerVersion: String by project
val junitJupiterVersion: String by project

application {
    mainClass.set("com.movie.info.ApplicationKt")
}

plugins {
    application
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.serialization") version "1.5.0"
}

allprojects {
    group = "com.movie.info"
    version = "0.0.1"

    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }

    apply(plugin = "kotlin")

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
            javaParameters = true
        }
    }
}

subprojects {
    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect", kotlinLanguageVersion))
        implementation("io.insert-koin:koin-core:$koinVersion")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinLanguageVersion")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-debug:$kotlinLanguageVersion")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:$kotlinLanguageVersion")
        testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
        testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
        testImplementation("io.mockk:mockk:$mockkVersion")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    }
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-jackson:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("io.ktor:ktor-client-apache:$ktorVersion")
    implementation("org.kodein.di:kodein-di:$kodeinVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")

    testCompile("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
}