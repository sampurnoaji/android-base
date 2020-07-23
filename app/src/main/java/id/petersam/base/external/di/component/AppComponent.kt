package id.petersam.base.external.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import id.petersam.base.MyApplication
import id.petersam.base.external.di.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityInjectionModule::class,
        FragmentInjectionModule::class,
        ContextModule::class,
        NetworkModule::class,
        SharedPreferenceModule::class,
        CoroutineDispatcherModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(instance: MyApplication?)
}
