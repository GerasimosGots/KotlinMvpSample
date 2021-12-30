package com.app.kotlinmvpsample.presentation.feature.userList

import com.app.kotlinmvpsample.presentation.base.BaseView
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenter

/**
 * Created by Gerasimos on 20/11/2021
 *
 * Contract between UseDetailsFragment and UserDetailsPresenter
 */
interface UserListFragmentContract {

    /**
     * Contract with View (e.g Fragment, Activity)
     */
    interface View : BaseView {
        fun onUserListFetched(UIUserModelList: MutableList<UIUserListModel>)
    }

    /**
     * Contract with Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun requestData()

        fun onUserSelected(id: String)
    }

    /**
     * Contract with Adapter
     */
    interface Adapter {
        fun onCardListClicked(id: String)
    }
}