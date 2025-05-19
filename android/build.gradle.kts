plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    // ... other android config

    applicationVariants.all {
        outputs.all {
            if (buildType.name == "release") {
                (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl).outputFileName = "roadsidepros-release.apk"
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