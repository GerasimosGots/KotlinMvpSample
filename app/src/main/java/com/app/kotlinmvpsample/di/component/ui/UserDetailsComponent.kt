package com.app.kotlinmvpsample.di.component.ui

import com.app.kotlinmvpsample.di.component.ApplicationComponent
import com.app.kotlinmvpsample.di.module.ui.UserDetailsModule
import com.app.kotlinmvpsample.di.scope.FragmentScope
import com.app.kotlinmvpsample.presentation.feature.userDetails.UserDetailsFragment
import dagger.Component

/**
 * Created by Gerasimos on 28/12/2021
 */
@FragmentScope
@Component(modules = [UserDetailsModule::class], dependencies = [ApplicationComponent::class])
interface UserDetailsComponent {
    fun inject(fragment: UserDetailsFragment)
}