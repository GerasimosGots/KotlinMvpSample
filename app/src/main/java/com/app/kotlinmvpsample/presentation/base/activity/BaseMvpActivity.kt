package com.app.kotlinmvpsample.presentation.base.activity

import android.os.Bundle
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenter
import com.app.kotlinmvpsample.presentation.base.BaseView
import javax.inject.Inject

/**
 * Created by Gerasimos on 20/11/2021
 */
abstract class BaseMvpActivity<V : BaseView, P : BasePresenter<V>> : BaseDaggerActivity() {

    var presenter: P? = null
        @Inject set

    protected abstract fun injectDependencies() : P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = injectDependencies()
        presenter?.onAttachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetachView()
    }
}