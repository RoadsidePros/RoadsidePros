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

    applicationVariants.all { variant ->
        variant.outputs.all { output ->
            if (variant.buildType.name == "release") {
                val outputImpl = output as com.android.build.gradle.internal.api.BaseVariantOutputImpl
                outputImpl.outputFileName.set("roadsidepros.apk")
            }
        }
    }
}

flutter {
    source = "../.."
}