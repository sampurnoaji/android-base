package id.petersam.login.di

import dagger.Module
import dagger.Provides
import id.petersam.core.di.scope.FeatureScope
import id.petersam.login.data.network.UserService
import id.petersam.login.data.source.UserRemoteDataSource
import retrofit2.Retrofit

@Module
class LoginModule {
    @Provides
    @FeatureScope
    fun provideUserService(retrofit: Retrofit) : UserService = retrofit.create(
        UserService::class.java)

    @Provides
    @FeatureScope
    fun provideRemoteDataSource(userService: UserService) = UserRemoteDataSource(userService)
}