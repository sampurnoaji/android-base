package id.petersam.base.data.network

import android.content.SharedPreferences
import id.petersam.base.data.vo.Preference
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor(private val preference: SharedPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "wisp ${preference.getString(Preference.PREF_KEY_AUTH_TOKEN, null)}")
            .build()

        return chain.proceed(newRequest)
    }
}
