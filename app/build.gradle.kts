    plugins {
        alias(libs.plugins.android.application)
        alias(libs.plugins.jetbrains.kotlin.android)
        id("com.google.dagger.hilt.android") // Hilt
         kotlin("kapt") // Añade esto
        id("androidx.navigation.safeargs.kotlin") // Navigation Component SafeArgs

    }

    android {
        namespace = "com.example.loginactivity"
        compileSdk = 34

        defaultConfig {
            applicationId = "com.example.loginactivity"
            minSdk = 24
            targetSdk = 34
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
        viewBinding {
            enable = true
        }
        buildFeatures{
    viewBinding = true
        }
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        // Retrofit for network requests
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        // Coroutines for async programming
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

        // RecyclerView, CardView, and Material Design
        implementation("androidx.recyclerview:recyclerview:1.2.1")
        implementation("androidx.cardview:cardview:1.0.0")
        implementation("com.google.android.material:material:1.5.0")
        implementation("androidx.coordinatorlayout:coordinatorlayout:1.1.0")

        // Hilt for dependency injection
        implementation("com.google.dagger:hilt-android:2.44")
        kapt("com.google.dagger:hilt-android-compiler:2.44")

        // Navigation Component for fragment navigation
        implementation("androidx.navigation:navigation-fragment-ktx:2.7.0")
        implementation("androidx.navigation:navigation-ui-ktx:2.7.0")

        // ViewModel and LiveData for MVVM
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    }
    kapt {
        correctErrorTypes = true
    }