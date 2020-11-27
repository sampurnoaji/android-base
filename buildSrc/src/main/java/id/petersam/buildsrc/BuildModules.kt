package id.petersam.buildsrc

object BuildModules {
    const val APP = ":app"
    const val CORE = ":core"

    object Features {
        const val LOGIN = ":features:login"
        const val HOME = ":features:home"
    }

    object Commons {
        const val UI = ":commons:ui"
        const val VIEWS = ":commons:views"
    }
}