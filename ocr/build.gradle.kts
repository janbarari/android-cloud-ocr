plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode(1)
        versionName("1.0.0")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

}

dependencies {

    //region Kotlin
    api("org.jetbrains.kotlin:kotlin-stdlib:1.5.20")
    //endregion

    //region Gson(Json Parser)
    api("com.google.code.gson:gson:2.8.6")
    //endregion

    //region Network
    api("com.squareup.okhttp3:okhttp:4.8.1")
    //endregion

    //region Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")
    //endregion

    //region Image Compressor
    implementation("id.zelory:compressor:3.0.1")
    //endregion
}