package com.app.kotlinmvpsample.presentation.base.presenter

import com.app.kotlinmvpsample.presentation.base.BaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * Created by Gerasimos on 20/11/2021
 */
open class BasePresenterImpl<V : BaseView> : BasePresenter<V> {

    protected var view: V? = null
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onAttachView(view: V) {
        this.view = view
    }

    override fun onDetachView() {
        view = null
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

    protected open fun addToDisposable(disposable: Disposable?) {
        compositeDisposable.addAll(disposable)
    }
}