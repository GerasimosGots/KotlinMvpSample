package com.app.kotlinmvpsample

import android.app.Application
import com.app.kotlinmvpsample.di.component.ApplicationComponent
import com.app.kotlinmvpsample.di.component.DaggerApplicationComponent
import com.app.kotlinmvpsample.di.module.ApplicationModule
import com.app.kotlinmvpsample.di.module.NetworkModule
import com.app.kotlinmvpsample.di.module.RepositoryModule
import com.app.kotlinmvpsample.di.module.UseCaseModule
import timber.log.Timber

/**
 * Created by Gerasimos on 20/11/2021
 */
class App : Application() {

    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        // Logging only in Debug variant
        Timber.plant(Timber.DebugTree())
    }


    // Return a Dagger ApplicationComponent
    fun getApplicationComponent(): ApplicationComponent? {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule())
                .useCaseModule(UseCaseModule())
                .repositoryModule(RepositoryModule())
                .build()
        }
        return mApplicationComponent
    }
}