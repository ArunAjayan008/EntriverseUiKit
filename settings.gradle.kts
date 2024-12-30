pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        ivy {
            url = uri("https://my.ivy.repo/repo")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        ivy {
            url = uri("https://my.ivy.repo/repo")
        }
    }
}

rootProject.name = "Entriverse UI"
include(":app")
include(":entriverse-ui")
