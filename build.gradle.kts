import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.4.10"
    // __UPDATE_COMPOSE_VERSION_MARKER__
    id("org.jetbrains.compose") version (System.getenv("COMPOSE_TEMPLATE_COMPOSE_VERSION") ?: "0.1.0-build113")
    kotlin("plugin.serialization") version "1.4.10"
}

repositories {
    jcenter()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("io.ktor:ktor-client-core:1.4.0")
    implementation("io.ktor:ktor-client-cio:1.4.0")
    implementation("io.ktor:ktor-client-serialization-jvm:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KotlinJvmComposeDesktopApplication"
        }
    }
}
