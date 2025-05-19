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
    // ... other android config ...

    applicationVariants.all { variant ->
        variant.outputs.all { output ->
            if (variant.buildType.name == "release") {
                // For AGP < 7.0.0, this works:
                output.outputFileName = "RoadsidePros-release.apk"
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