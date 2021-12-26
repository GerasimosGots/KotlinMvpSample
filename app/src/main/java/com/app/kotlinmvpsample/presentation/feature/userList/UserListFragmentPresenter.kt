package com.app.kotlinmvpsample.presentation.feature.userList

import com.app.kotlinmvpsample.domain.useCase.UserUseCase
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenterImpl
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

/**
 * Created by Gerasimos on 20/11/2021
 */
class UserListFragmentPresenter
@Inject constructor(private val userUseCase: UserUseCase) :
    BasePresenterImpl<UserListFragmentContract.View>(),
    UserListFragmentContract.Presenter {

    override fun requestData() {
        userUseCase.getUserList()
            .subscribeBy(
                onSuccess = { userModelList ->
                    view?.onUserListFetched(userModelList = userModelList.toUserListModel())
                },
                onError = {
                    it.printStackTrace()
                }
            )
            .addTo(compositeDisposable = compositeDisposable)
    }

    override fun onUserSelected(id: String) {
        //TODO maybe single ?
        userUseCase.selectedUser(id = id)
    }
}