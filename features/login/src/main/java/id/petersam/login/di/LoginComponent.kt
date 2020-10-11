package id.petersam.login.di

import dagger.Component
import id.petersam.core.di.CoreComponent
import id.petersam.core.di.scope.FeatureScope
import id.petersam.login.presentation.LoginFragment

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        LoginModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface LoginComponent {
    fun inject(loginFragment: LoginFragment)
}