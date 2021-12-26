package com.app.kotlinmvpsample.di.module

import com.app.kotlinmvpsample.domain.useCase.UserUseCase
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragmentContract
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragmentPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Gerasimos on 14/12/2021
 */

@Module
class PresenterModule {
    @Provides
    fun bindsPresenter(userUseCase: UserUseCase): UserListFragmentContract.Presenter{
        return UserListFragmentPresenter(userUseCase)
    }

    /*@Binds
    abstract fun bindUserListPresenter(presenter: UserListFragmentPresenter): UserListFragmentPresenter*/


   /* @FragmentScope
    @ContributesAndroidInjector(modules = [FeatureListPresenterModule::class])
    abstract fun contributeUserListPresenter(): UserListFragmentContract.Presenter


    @FragmentScope
    @ContributesAndroidInjector
    fun provideUserListPresenter(userUseCaseImpl: UserUseCaseImpl): UserListFragmentContract.Presenter {
        return UserListFragmentPresenter(
            userUseCase = userUseCaseImpl
        )
    }*/
   /* @FragmentScope
    @ContributesAndroidInjector(*//*modules = [UserListPresenterModule::class]*//*)
    abstract fun contributeFeatureListPresenter(): UserListFragmentPresenter*/
}