plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

android {
    applicationVariants.all { variant ->
        variant.outputs.all { output ->
            if (variant.buildType.name == "release") {
                outputFileName = "RoadsidePros-release.apk"
            }
        }
    }
}

def newBuildDir = new File(rootDir, "../build")
buildDir = newBuildDir

subprojects {
    buildDir = new File(rootProject.buildDir, name)
    evaluationDependsOn(":app")
}

tasks.register("clean", Delete) {
    delete rootProject.buildDir
}