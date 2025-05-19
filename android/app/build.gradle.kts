plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.roadsidepros.roadsidepros"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.roadsidepros.roadsidepros"
        minSdk = 19
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    // FIXED: Use 'applicationVariants.all' with correct lambda signature and output file name assignment
    applicationVariants.all {
        outputs.all {
            // Only for APK (not for AAB)
            if (this is com.android.build.gradle.internal.api.BaseVariantOutputImpl && buildType.name == "release") {
                outputFileName = "roadsidepros.apk"
            }
        }
    }
}

flutter {
    source = "../.."
}