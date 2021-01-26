package main.backend.helpers

import io.qameta.allure.okhttp3.AllureOkHttp3
import main.backend.helpers.Properties.Companion.properties
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration

object RetrofitClient {

    val HOST = if (System.getProperty("HOST").isNullOrBlank()) "https://randomuser.me/"
    else System.getProperty("HOST")

    private val timeout = Duration.ofSeconds(10)
    private val client = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .callTimeout(timeout)
        .connectTimeout(timeout)
        .readTimeout(timeout)
        .writeTimeout(timeout)
        .addInterceptor(AllureOkHttp3())
        .addInterceptor { chain: Interceptor.Chain ->
            val builder = chain.request().newBuilder()
            chain.proceed(builder.build())
        }
        .build()


    fun <T> createService(service: Class<T>): T =
        Retrofit.Builder()
            .baseUrl(properties().serverHostname)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(service)
}