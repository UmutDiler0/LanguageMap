import org.jetbrains.kotlin.fir.declarations.builder.buildScript
buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.8.0"
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
    }
}
plugins {

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}