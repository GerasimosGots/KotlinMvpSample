package com.app.kotlinmvpsample.presentation.feature.userList

import com.app.kotlinmvpsample.presentation.base.BaseView
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenter

/**
 * Created by Gerasimos on 20/11/2021
 */
interface UserListFragmentContract {

    interface View : BaseView {
        fun onUserListFetched(userModelList: MutableList<UserListModel>)
    }

    interface Presenter : BasePresenter<View> {
        fun requestData()

        fun onUserSelected(id: String)
    }

    interface Adapter {
        fun onCardListClicked(id: String)
    }
}