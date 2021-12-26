package com.app.kotlinmvpsample.di.component

import android.app.Application
import com.app.kotlinmvpsample.App
import com.app.kotlinmvpsample.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Gerasimos on 20/11/2021
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        NetworkModule::class,
        PresenterModule::class,

        //Activity - Fragments
        FragmentBuilderModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun applicationModule(applicationModule: ApplicationModule): Builder

        fun networkModule(networkModule: NetworkModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder

        fun useCaseModule(useCaseModule: UseCaseModule): Builder
        fun build(): ApplicationComponent
    }

    override fun inject(app: App)
    /**
     * - Modules are classes or interfaces that act as collection of instructions for Dagger in how
     * to construct dependencies.
     * - Binds methods are one way to tell Dagger how to construct an instance. They are abstract
     * methods On Modules that associate one type that Dagger already knows how to construct
     * (the method parameter) with a type that Dagger does not yet know how to construct
     * (the methods return type)
     * - Provides methods are concrete methods in a module that tells Dagger that when something
     * requests an instance of the type the method returns, it should call that method to get an
     * instance
     *- AndroidInjectionModule : We didn’t create this. It is an internal class in Dagger 2.10.
     * Provides our activities and fragments with given module.
     */
}
