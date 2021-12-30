package com.app.kotlinmvpsample.di.module.ui

import com.app.kotlinmvpsample.di.scope.FragmentScope
import com.app.kotlinmvpsample.domain.useCase.UserUseCase
import com.app.kotlinmvpsample.presentation.feature.userDetails.UserDetailsContract
import com.app.kotlinmvpsample.presentation.feature.userDetails.UserDetailsPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Gerasimos on 28/12/2021
 */
@Module
class UserDetailsModule {

    @FragmentScope
    @Provides
    fun bindsPresenter(userUseCase: UserUseCase): UserDetailsContract.Presenter {
        return UserDetailsPresenter(userUseCase)
    }
}