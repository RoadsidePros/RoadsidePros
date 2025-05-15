// ✅ Add this plugins block at the top
plugins {
    id("com.google.gms.google-services") version "4.4.2" apply false
    kotlin("android") version "2.1.0" apply false // <-- Add this line
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

android {
    applicationVariants.all {
        outputs.all {
            if (buildType.name == "release") {
                outputFileName.set("RoadsidePros-release.apk")
            }
        }
    }
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