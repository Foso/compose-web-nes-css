
plugins {
    kotlin("multiplatform") version "1.5.30"
    id("org.jetbrains.compose") version "1.0.0-alpha4-build348"
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(compose.web.widgets)
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
               // implementation(npm("nes.css","2.3.0"))
                implementation(compose.web.widgets)
                implementation(compose.web.core)
                implementation(compose.runtime)
            }
        }
    }
}

afterEvaluate {
    rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        versions.webpackDevServer.version = "4.0.0"
    }
}