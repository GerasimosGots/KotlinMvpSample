package com.app.kotlinmvpsample.di.module

import com.app.kotlinmvpsample.data.network.SchedulerProvider
import com.app.kotlinmvpsample.data.network.service.UserService
import com.app.kotlinmvpsample.data.repository.UserRepository
import com.app.kotlinmvpsample.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Gerasimos on 20/11/2021
 */
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideUserRepository(
        provider: SchedulerProvider,
        userService: UserService
    ): UserRepository {
        return UserRepositoryImpl(
            provider = provider,
            userService = userService
        )
    }
}