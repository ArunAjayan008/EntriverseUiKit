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
                implementation(libs.ui)
                implementation(libs.ui.tooling.preview)
                implementation(libs.androidx.compose.ui.ui.tooling.preview)
                implementation(libs.androidx.activity.compose.v182)
                implementation(libs.androidx.lifecycle.viewmodel.compose)
                implementation(libs.androidx.runtime.rxjava2)
                implementation(libs.androidx.multidex)
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
    namespace = "me.entri.entriverseui"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        multiDexEnabled = true
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
dependencies {
    debugImplementation(libs.androidx.compose.ui.ui.tooling)
}
