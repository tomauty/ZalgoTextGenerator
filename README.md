ZalgoTextGenerator
==================

An Android app to easily generate Zalgo text strings and share them with other Android apps.

Compilation
-----------

Retrofit is built using Maven and there is a very minimal amount of setup required for compilation.

Two environment variables are required which point to your Android SDK and native Android SDK. A common
place to put these is in a `.bash_profile` file in your home directory.

    export ANDROID_HOME=/path/to/android/sdk
    export ANDROID_NDK_HOME=/path/to/android/ndk

With these two environment variables loaded you can compile the modules and sample application by running
`mvn clean install`. Each module's built artifact will be in its respective `target/` folder.
