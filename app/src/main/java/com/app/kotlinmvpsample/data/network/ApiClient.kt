package com.app.kotlinmvpsample.data.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Gerasimos on 21/11/2021
 */
object ApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    private const val SECONDARY_URL = "https://picsum.photos"

    private var mRetrofit: Retrofit = createPrimaryRetrofitClient()

    fun createPrimaryRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .client(buildOkhttpClient())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    fun createSecondaryRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .client(buildOkhttpClient())
            .baseUrl(SECONDARY_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    private fun buildOkhttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.MINUTES)
        return clientBuilder.build()
    }

    private fun <T> buildService(service: Class<T>): T {
        return mRetrofit.create(service)
    }
}