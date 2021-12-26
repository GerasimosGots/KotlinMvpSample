package com.app.kotlinmvpsample.di.module

import com.app.kotlinmvpsample.data.network.ApiClient
import com.app.kotlinmvpsample.data.network.SchedulerProvider
import com.app.kotlinmvpsample.data.network.SchedulerProviderImpl
import com.app.kotlinmvpsample.data.network.service.PhotoService
import com.app.kotlinmvpsample.data.network.service.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Gerasimos on 20/11/2021
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideScheduleProvider(): SchedulerProvider {
        return SchedulerProviderImpl()
    }

    @Singleton
    @Provides
    fun provideApiClient(): Retrofit {
        return ApiClient.createPrimaryRetrofitClient()
    }

   /* @Singleton
    @Provides
    fun provideSecondaryApiClient(): Retrofit {
        return ApiClient.createSecondaryRetrofitClient()
    }*/

    @Provides
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    fun providePhotoService(retrofit: Retrofit): PhotoService {
        return retrofit.create(PhotoService::class.java)
    }
}