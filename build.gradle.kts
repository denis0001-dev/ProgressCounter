plugins {
    kotlin("multiplatform") version "2.0.21"
}

group = "ru.morozovit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
}