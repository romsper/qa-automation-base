package main.backend.helpers

import io.qameta.allure.okhttp3.AllureOkHttp3
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class Retrofit {

    val HOST = if (System.getProperty("HOST").isNullOrEmpty()) "https://randomuser.me/"
    else System.getProperty("HOST")

    val client = OkHttpClient.Builder().addInterceptor(AllureOkHttp3()).addInterceptor { chain ->
        val newRequest = chain.request().newBuilder()
                .build()
        chain.proceed(newRequest)
    }.build()


    fun retrofit(): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}

inline fun <reified T> Response<T>.getAsObject(): T {
    return body()!! }

inline fun <reified T> Response<T>.getErrorBody(): String {
    return errorBody()!!.string() }