package com.app.kotlinmvpsample.di.module.ui

import com.app.kotlinmvpsample.di.scope.FragmentScope
import com.app.kotlinmvpsample.domain.useCase.UserUseCase
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragmentContract
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragmentPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Gerasimos on 16/12/2021
 */

@Module
class UserListModule {

    @FragmentScope
    @Provides
    fun bindsPresenter(userUseCase: UserUseCase): UserListFragmentContract.Presenter {
        return UserListFragmentPresenter(userUseCase)
    }
}