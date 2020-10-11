package id.petersam.buildsrc.dependencies

import id.petersam.buildsrc.BuildDependenciesVersions

object AnnotationProcessorsDependencies {
    const val DAGGER = "com.google.dagger:dagger-compiler:${BuildDependenciesVersions.DAGGER}"
    const val ROOM = "androidx.room:room-compiler:${BuildDependenciesVersions.ROOM}"
}