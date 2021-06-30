
buildscript {

    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.0")
    }

}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}