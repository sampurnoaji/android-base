package id.petersam.base.external.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import id.petersam.base.MyApplication
import javax.inject.Singleton

@Module
class ContextModule(val application: MyApplication) {
    @Provides
    @Singleton
    fun provideContext(): Context = application
}
