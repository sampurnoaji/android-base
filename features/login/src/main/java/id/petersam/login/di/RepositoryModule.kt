package id.petersam.login.di

import dagger.Binds
import dagger.Module
import id.petersam.login.data.repository.UserRepositoryImpl
import id.petersam.login.domain.UserRepository

@Module
interface RepositoryModule {
    @Binds
    fun bindRepository(repository: UserRepositoryImpl): UserRepository
}