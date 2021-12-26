package com.app.kotlinmvpsample.di.module

import com.app.kotlinmvpsample.data.repository.UserRepository
import com.app.kotlinmvpsample.domain.useCase.UserUseCase
import com.app.kotlinmvpsample.domain.useCase.UserUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Gerasimos on 20/11/2021
 */
@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideFeatureUseCase(userRepository: UserRepository): UserUseCase {
        return UserUseCaseImpl(
            userRepository = userRepository
        )
    }
}