plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0" // Добавьте плагин
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "me.klimvlad.moneytransfer.App"
}

javafx {
    version = "21" // Версия JavaFX
    modules = listOf("javafx.controls", "javafx.graphics") // Требуемые модули
}
