package com.app.kotlinmvpsample.presentation.base.activity

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.presentation.base.BaseView
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenter
import javax.inject.Inject

/**
 * Created by Gerasimos on 20/11/2021
 *
 * This activity class extends the [BaseActivity].
 * This class used only as extension of other classes
 * To Extend this Activity you must provide as generic parameters
 *  - VB type of [ViewBinding]
 *  - V type of [BaseView] (BaseContract)
 *  - P presenter type of [BasePresenter]
 *  The BasePresenter class need a generic parameter of
 *      - V type of View (Contract)
 *
 *  This class is responsible to attach/detach the presenter (base on the MVP pattern)
 *  and inject dependencies (nn that case we inject only the presenter)
 */
abstract class BaseMvpActivity<VB : ViewBinding, V : BaseView, P : BasePresenter<V>> : BaseActivity<VB>() {

    protected var presenter: P? = null

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