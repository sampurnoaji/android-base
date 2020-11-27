package id.petersam.core.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import id.petersam.core.vo.Preference
import javax.inject.Singleton

@Module
class SharedPreferenceModule {
    @Provides
    @Singleton
    fun providesPreference(context: Context): SharedPreferences = context.getSharedPreferences(Preference.APP_PREF, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providesSharedPreference(sharedPreferences: SharedPreferences): SharedPreferences.Editor = sharedPreferences.edit()
}