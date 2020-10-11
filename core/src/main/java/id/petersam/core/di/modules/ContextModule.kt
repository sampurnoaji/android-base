package id.petersam.core.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule() {
    @Singleton
    @Provides
    fun provideContext(app: Application): Context = app
}