package id.petersam.base.external.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.petersam.base.presentation.home.HomeFragment
import id.petersam.base.presentation.login.LoginFragment

@Module
abstract class FragmentInjectionModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment
}
