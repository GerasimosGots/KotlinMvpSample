package com.app.kotlinmvpsample.presentation.base

/**
 * Created by Gerasimos on 20/11/2021
 *
 * Base interface view that will be extended in every Contract (between Fragment and Presenter)
 */
interface BaseView {
    fun showLoading()
    fun dismissLoading()
}