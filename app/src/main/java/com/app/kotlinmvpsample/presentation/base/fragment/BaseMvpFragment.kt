package com.app.kotlinmvpsample.presentation.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.kotlinmvpsample.App
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenter
import com.app.kotlinmvpsample.presentation.base.BaseView
import javax.inject.Inject

/**
 * Created by Gerasimos on 27/11/2021
 */
abstract class BaseMvpFragment<V : BaseView, P : BasePresenter<V>> : BaseDaggerFragment(),
    BaseView {

    protected var presenter: P? = null

    protected var app: App? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = injectDependencies()
        presenter?.onAttachView(this as V)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected abstract fun injectDependencies() : P?

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