package com.app.kotlinmvpsample.data.network

import io.reactivex.Scheduler

/**
 * Created by Gerasimos on 21/11/2021
 */
interface SchedulerProvider {
    fun io() : Scheduler
    fun ui() : Scheduler
    fun computation() : Scheduler
}