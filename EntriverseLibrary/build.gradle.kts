plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
    id("maven-publish")
}



buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.androidx.core.ktx)
                implementation(libs.androidx.appcompat)
                implementation(libs.material)
                implementation(libs.androidx.foundation.android)
                implementation(libs.androidx.material3.android)

                val composeBom =
                    project.dependencies.platform("androidx.compose:compose-bom:2024.04.00")
                implementation(composeBom)
                implementation("androidx.compose.ui:ui")
                implementation("androidx.compose.ui:ui-tooling-preview")
                implementation("androidx.compose.ui:ui-tooling-preview")
                implementation("androidx.activity:activity-compose:1.8.2")
                implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
                implementation("androidx.compose.runtime:runtime-rxjava2")
            }
        }
            commonTest.dependencies {

            }
        }
    }



publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.ArunAjayan008"
            artifactId = "EntriverseUiKit"
            version = "0.0.8"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

android {
    namespace = "me.arunajayan.entriverselibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}
