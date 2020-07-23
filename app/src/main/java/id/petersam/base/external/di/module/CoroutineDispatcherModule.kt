package id.petersam.base.external.di.module

import dagger.Binds
import dagger.Module
import id.petersam.base.data.dispatcher.CoroutineDispatcherProvider
import id.petersam.base.data.dispatcher.DispatcherProvider

@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider): DispatcherProvider
}
