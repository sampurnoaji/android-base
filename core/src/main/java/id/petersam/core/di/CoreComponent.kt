package id.petersam.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.BindsInstance
import dagger.Component
import id.petersam.core.di.modules.ContextModule
import id.petersam.core.di.modules.CoroutineDispatcherModule
import id.petersam.core.di.modules.NetworkModule
import id.petersam.core.di.modules.SharedPreferenceModule
import id.petersam.core.dispatcher.DispatcherProvider
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        CoroutineDispatcherModule::class,
        NetworkModule::class,
        SharedPreferenceModule::class
    ]
)
interface CoreComponent {
    fun context(): Context
    fun sharedPreference(): SharedPreferences
    fun sharedPreferenceEditor(): SharedPreferences.Editor
    fun retrofit(): Retrofit
    fun dispatcher(): DispatcherProvider

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }
}