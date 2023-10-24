plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.qrsccaner"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.qrsccaner"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //CAMARA
    implementation("androidx.camera:camera-camera2:1.1.0")
    implementation("com.afollestad.assent:core:3.0.0-RC4")
    implementation("androidx.camera:camera-view:1.3.0")

    //LOTTIE
    // animations
    implementation("com.airbnb.android:lottie:5.2.0")

    // ml
    implementation("com.google.mlkit:barcode-scanning:17.0.2")
    implementation("androidx.camera:camera-lifecycle:1.3.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}