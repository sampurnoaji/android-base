package id.petersam.base.external.di.module

import dagger.Binds
import dagger.Module
import id.petersam.base.data.repository.UserRepositoryImpl
import id.petersam.base.domain.repository.UserRepository

@Module
interface RepositoryModule {
    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository
}
