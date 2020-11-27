package id.petersam.core.di.modules

import dagger.Binds
import dagger.Module
import id.petersam.core.dispatcher.CoroutineDispatcherProvider
import id.petersam.core.dispatcher.DispatcherProvider

@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider) : DispatcherProvider
}