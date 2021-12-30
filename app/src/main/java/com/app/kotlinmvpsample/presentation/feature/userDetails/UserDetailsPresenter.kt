package com.app.kotlinmvpsample.presentation.feature.userDetails

import com.app.kotlinmvpsample.domain.useCase.UserUseCase
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenterImpl
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

/**
 * Created by Gerasimos on 27/11/2021
 */
class UserDetailsPresenter @Inject constructor(private val userUseCase: UserUseCase) :
    BasePresenterImpl<UserDetailsContract.View>(),
    UserDetailsContract.Presenter {

    override fun requestSelectedUser() {
        userUseCase.getSelectedUser()
            .subscribeBy(
                onSuccess = { userModel ->
                    view?.onUserModelFetched(UserModel = userModel)
                },
                onError = {
                    it.printStackTrace()
                }
            )
            .addTo(compositeDisposable = compositeDisposable)
    }
}