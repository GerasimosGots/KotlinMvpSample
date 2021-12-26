package com.app.kotlinmvpsample.presentation.base.presenter

import com.app.kotlinmvpsample.presentation.base.BaseView

/**
 * Created by Gerasimos on 20/11/2021
 */
interface BasePresenter<V : BaseView> {
    fun onAttachView(view: V)
    fun onDetachView()
}