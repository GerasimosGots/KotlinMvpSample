package com.app.kotlinmvpsample

import com.app.kotlinmvpsample.di.component.DaggerApplicationComponent
import com.app.kotlinmvpsample.di.module.*
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

/**
 * Created by Gerasimos on 20/11/2021
 */
class App : DaggerApplication() {


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
            .application(this)
            .applicationModule(ApplicationModule(this))
            .useCaseModule(UseCaseModule())
            .repositoryModule(RepositoryModule())
            //.presenterModule(PresenterModule())
            .networkModule(NetworkModule())
            .build()
    }
}