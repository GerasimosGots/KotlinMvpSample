package com.app.kotlinmvpsample.di.component.ui

import com.app.kotlinmvpsample.di.scope.FragmentScope
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragment
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by Gerasimos on 16/12/2021
 */

@Module
class FeatureListPresenterModule {

    @FragmentScope
    @Provides
    fun bindsPresenter(presenter: UserListFragment): UserListFragment{
        return UserListFragment()
    }
}