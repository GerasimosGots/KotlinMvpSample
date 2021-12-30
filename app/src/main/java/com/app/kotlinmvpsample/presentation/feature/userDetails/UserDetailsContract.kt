package com.app.kotlinmvpsample.presentation.feature.userDetails

import com.app.kotlinmvpsample.domain.useCase.UserModel
import com.app.kotlinmvpsample.presentation.base.BaseView
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenter

/**
 * Created by Gerasimos on 27/11/2021
 *
 * Contract between UserListFragment and UserListPresenter
 */
interface UserDetailsContract {

    /**
     * Contract with View (e.g Fragment, Activity)
     */
    interface View : BaseView {
        fun onUserModelFetched(UserModel: UserModel)
    }

    /**
     * Contract with Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun requestSelectedUser()
    }
}