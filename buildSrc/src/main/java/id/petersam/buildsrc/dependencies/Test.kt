package id.petersam.buildsrc.dependencies

import id.petersam.buildsrc.BuildDependenciesVersions

object Test {
    const val JUNIT = "junit:junit:${BuildDependenciesVersions.JUNIT}"
    const val EXT = "androidx.test.ext:junit:${BuildDependenciesVersions.EXT}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${BuildDependenciesVersions.ESPRESSO}"
}