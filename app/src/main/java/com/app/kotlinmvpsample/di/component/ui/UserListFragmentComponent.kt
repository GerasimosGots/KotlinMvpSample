package com.app.kotlinmvpsample.di.component.ui

import com.app.kotlinmvpsample.di.component.ApplicationComponent
import com.app.kotlinmvpsample.di.module.ui.UserListModule
import com.app.kotlinmvpsample.di.scope.FragmentScope
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragment
import dagger.Component
import dagger.Module

/**
 * Created by Gerasimos on 21/11/2021
 */

@FragmentScope
@Component(modules = [UserListModule::class], dependencies = [ApplicationComponent::class])
interface UserListFragmentComponent {
    fun inject(fragment: UserListFragment)
}