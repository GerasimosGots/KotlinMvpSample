package com.app.kotlinmvpsample.di.module

import android.app.Application
import android.content.Context
import com.app.kotlinmvpsample.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Gerasimos on 20/11/2021
 */
@Module
class ApplicationModule constructor(var app : App) {

    @Singleton
    @Provides
    fun provideContext() : Context = app.applicationContext

    @Singleton
    @Provides
    fun provideApplication() : Application = app
}