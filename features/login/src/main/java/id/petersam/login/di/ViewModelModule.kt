package id.petersam.login.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.petersam.core.di.annotation.ViewModelKey
import id.petersam.core.di.factory.ViewModelFactory
import id.petersam.login.presentation.LoginViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun providesLoginViewModel(viewModel: LoginViewModel): ViewModel
}