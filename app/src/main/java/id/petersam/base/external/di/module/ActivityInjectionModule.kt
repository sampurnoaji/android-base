package id.petersam.base.external.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.petersam.base.presentation.MainActivity

@Module
abstract class ActivityInjectionModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
