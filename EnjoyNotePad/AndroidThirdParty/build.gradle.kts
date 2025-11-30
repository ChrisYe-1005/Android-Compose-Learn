// gradle/AndroidThirdParty.kts

// 定义版本号（集中管理）
object Versions {
    const val kotlin = "1.9.24"
    const val agp = "8.5.0"

    // AndroidX
    const val appcompat = "1.6.1"
    const val activityCompose = "1.9.1"
    const val lifecycle = "2.8.4"
    const val composeBom = "2024.09.00"

    // Room
    const val room = "2.6.1"

    // Network
    const val retrofit = "2.11.0"
    const val okhttp = "4.12.0"

    // DI
    const val hilt = "2.51.1"

    // Image Loading
    const val coil = "2.6.0"

    // Coroutines
    const val coroutines = "1.8.1"
}

// 定义依赖坐标（字符串形式）
object Libs {
    // AndroidX
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"

    // Compose (使用 BOM)
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"

    // Lifecycle
    const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    const val lifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycle}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // Retrofit + OkHttp
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    // Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    // Coil
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coil}"

    // Coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}