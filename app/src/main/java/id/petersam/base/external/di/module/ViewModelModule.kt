package id.petersam.base.external.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.petersam.base.external.di.annotation.ViewModelKey
import id.petersam.base.external.di.factory.ViewModelFactory
import id.petersam.base.presentation.home.HomeViewModel
import id.petersam.base.presentation.login.LoginViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun providesLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun providesHomeViewModel(viewModel: HomeViewModel): ViewModel
}
