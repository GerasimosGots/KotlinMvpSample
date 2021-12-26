package com.app.kotlinmvpsample.di.module

import com.app.kotlinmvpsample.di.component.ApplicationComponent
import com.app.kotlinmvpsample.di.module.ui.FeatureListFragmentModule
import com.app.kotlinmvpsample.di.scope.FragmentScope
import com.app.kotlinmvpsample.presentation.feature.userList.UserListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Gerasimos on 10/12/2021
 */

@Module
interface FragmentBuilderModule {

    //@FragmentScope
    @ContributesAndroidInjector(modules = [PresenterModule::class])
    fun contributeFeatureListFragment(): UserListFragment
}