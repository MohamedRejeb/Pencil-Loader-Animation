import com.mohamedbenrejeb.pencilloader.Configuration
import com.mohamedbenrejeb.pencilloader.Versions

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", Configuration.artifactGroup)
    set("PUBLISH_ARTIFACT_ID", "pencilloader")
    set("PUBLISH_VERSION", rootProject.extra.get("rootVersionName"))
}

apply(from ="${rootDir}/scripts/publish-module.gradle")

android {
    compileSdk = Configuration.compileSdk
    defaultConfig {
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    lint {
        abortOnError = false
    }
}

dependencies {
    implementation("androidx.compose.ui:ui:${Versions.compose}")
    implementation("androidx.compose.material3:material3:1.1.0-alpha03")
}