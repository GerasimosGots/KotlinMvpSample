package com.app.kotlinmvpsample.data.network

import com.app.kotlinmvpsample.BuildConfig
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Gerasimos on 21/11/2021
 */
object ApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    const val SECONDARY_URL = "https://picsum.photos/id/"

   fun createPrimaryRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .client(buildOkhttpClient())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    private fun buildOkhttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.MINUTES)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
            clientBuilder.addInterceptor(interceptor)
        }
        return clientBuilder.build()
    }
}