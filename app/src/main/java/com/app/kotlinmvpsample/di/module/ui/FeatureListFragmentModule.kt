package com.app.kotlinmvpsample.di.module.ui

import com.app.kotlinmvpsample.di.FragmentKey
import com.app.kotlinmvpsample.di.scope.FragmentScope
import com.app.kotlinmvpsample.domain.useCase.UserUseCase
import com.app.kotlinmvpsample.domain.useCase.UserUseCaseImpl
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragment
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragmentContract
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragmentPresenter
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import javax.inject.Named

/**
 * Created by Gerasimos on 21/11/2021
 */

@Module
interface FeatureListFragmentModule {

    /*@ContributesAndroidInjector
    abstract fun profileFragment(): UserListFragment*/

    //@FragmentScope
   /* @Binds
    @IntoMap
    @FragmentKey(UserListFragment::class)
    abstract fun bindsFragment(fragment: UserListFragment): UserListFragment

   */
}