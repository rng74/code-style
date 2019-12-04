package comers_0890.httpsvk.zapiskz.common.di

import comers_0890.httpsvk.zapiskz.BuildConfig
import comers_0890.httpsvk.zapiskz.common.Api
import comers_0890.httpsvk.zapiskz.common.TokenInterceptor
import comers_0890.httpsvk.zapiskz.common.TokenKeeper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun api(okHttpClient: OkHttpClient): Api = Retrofit.Builder()
        .baseUrl(BuildConfig.API_LINK)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(Api::class.java)

    @Provides
    @Singleton
    fun okHttpClient(tokenKeeper: TokenKeeper): OkHttpClient {
        val client = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(httpLoggingInterceptor)
        }
        client.readTimeout(60, TimeUnit.SECONDS)
        client.addInterceptor(TokenInterceptor(tokenKeeper))
        return client.build()
    }

    @Provides
    @Singleton
    fun tokenKeeper(): TokenKeeper = TokenKeeper("")
}