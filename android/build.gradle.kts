plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.roadsidepros.app" // <-- Replace with your actual package name if different
    compileSdk = 33

    defaultConfig {
        applicationId = "com.roadsidepros.app" // <-- Replace with your actual package name if different
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // APK renaming logic
    applicationVariants.all {
        outputs.all {
            if (buildType.name == "release") {
                outputFileName.set("RoadsidePros-release.apk")
            }
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")
    // Add any additional dependencies as needed
}

val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}