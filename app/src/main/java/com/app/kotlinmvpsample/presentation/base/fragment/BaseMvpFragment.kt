package com.app.kotlinmvpsample.presentation.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.App
import com.app.kotlinmvpsample.presentation.base.BaseView
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenter
import javax.inject.Inject

/**
 * Created by Gerasimos on 27/11/2021
 *
 * This fragment class extends the [BaseFragment].
 * This class used only as extension of other classes
 * To Extend this class you must provide as generic parameters
 *  - VB type of [ViewBinding]
 *  - V type of [BaseView] (BaseContract)
 *  - P presenter type of [BasePresenter]
 *  The BasePresenter class need a generic parameter of
 *      - V type of View (Contract)
 *
 *  This class is responsible to attach/detach the presenter (base on the MVP pattern)
 *  and inject dependencies (nn that case we inject only the presenter)
 */
abstract class BaseMvpFragment<VB : ViewBinding, V : BaseView, P : BasePresenter<V>> : BaseFragment<VB>(),
    BaseView {

    @Inject
    fun setBasePresenter(presenter: P) {
        this.presenter = presenter
    }

    protected var presenter: P? = null
    protected var app: App? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        injectDependencies()
        presenter?.onAttachView(this as V)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected abstract fun injectDependencies()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        app = activity?.application as App
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetachView()
    }

    override fun showLoading() {
        //show loading
    }

    override fun dismissLoading() {
        // dismiss loading
    }
}