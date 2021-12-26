package com.app.kotlinmvpsample.presentation.feature.userDetails

import com.app.kotlinmvpsample.domain.useCase.UserModel
import com.app.kotlinmvpsample.presentation.base.BaseView
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenter

/**
 * Created by Gerasimos on 27/11/2021
 */
interface UserDetailsContract {

    interface View : BaseView {
        fun onUserModelFetched(userModel: UserModel)
    }

    interface Presenter : BasePresenter<View> {
        fun requestSelectedUser()
    }
}