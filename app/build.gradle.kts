import java.util.Base64

plugins {
    id("com.android.application")
}

android {
    namespace = "com.unification.listbuilder"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.unification.listbuilder"
        minSdk = 24
        targetSdk = 35
        // CI passes -PversionCode=<run number> so each build installs over the last one.
        versionCode = (project.findProperty("versionCode") as String?)?.toInt() ?: 1
        versionName = "1." + versionCode
    }

    // One fixed signing key kept in the repository, so every build can install over the last
    // (Android refuses an update signed with a different key). Personal-use app: keep the repo private.
    signingConfigs {
        create("app") {
            // The key is stored as text (app/signing/unification.keystore.b64) and unpacked on first build.
            val ks = file("unification.keystore")
            if (!ks.exists()) {
                ks.writeBytes(Base64.getMimeDecoder().decode(file("signing/unification.keystore.b64").readText().trim()))
            }
            storeFile = ks
            storePassword = "unification"
            keyAlias = "unification"
            keyPassword = "unification"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("app")
        }
        debug {
            signingConfig = signingConfigs.getByName("app")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Keep the bundled page uncompressed and untouched.
    androidResources { noCompress += listOf("html") }
}
