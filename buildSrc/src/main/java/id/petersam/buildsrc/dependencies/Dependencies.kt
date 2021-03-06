package id.petersam.buildsrc.dependencies

import id.petersam.buildsrc.BuildDependenciesVersions

object Dependencies {
    const val MATERIAL = "com.google.android.material:material:${BuildDependenciesVersions.MATERIAL_DESIGN}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${BuildDependenciesVersions.RECYCLER_VIEW}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${BuildDependenciesVersions.NAVIGATION}"

    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT}"

    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.COROUTINES}"
    const val ROOM = "androidx.room:room-runtime:${BuildDependenciesVersions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${BuildDependenciesVersions.ROOM}"

    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${BuildDependenciesVersions.LIFECYCLE_EXTENSION}"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE_EXTENSION}"
    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.CONSTRAINT_LAYOUT}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${BuildDependenciesVersions.PAGING}"
    const val DAGGER = "com.google.dagger:dagger:${BuildDependenciesVersions.DAGGER}"
    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersions.TIMBER}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersions.RETROFIT}"
    const val LOGGING = "com.squareup.okhttp3:logging-interceptor:${BuildDependenciesVersions.LOGGING}"
    const val MOSHI = "com.squareup.moshi:moshi:${BuildDependenciesVersions.MOSHI}"
    const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${BuildDependenciesVersions.RETROFIT}"
}