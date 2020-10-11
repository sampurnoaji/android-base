package id.petersam.core

import android.app.Application
import android.content.Context
import id.petersam.core.di.CoreComponent
import id.petersam.core.di.DaggerCoreComponent

class MyApplication : Application() {
    lateinit var coreComponent: CoreComponent

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) = (context.applicationContext as? MyApplication)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }
}