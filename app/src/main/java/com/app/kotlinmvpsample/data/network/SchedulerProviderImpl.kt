package com.app.kotlinmvpsample.data.network

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Gerasimos on 21/11/2021
 */
class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {

    // For main thread
    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    // For IO thread, for networking
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    // For heavy or long running computation
    override fun computation(): Scheduler {
        return Schedulers.computation()
    }
}