package comers_0890.httpsvk.zapiskz.common

import comers_0890.httpsvk.zapiskz.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val tokenKeeper: TokenKeeper) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
            .removeHeader("Content-Type")
            .addHeader("Content-Type", "application/json")

        val request = builder.build()

        return chain.proceed(request)
    }
}