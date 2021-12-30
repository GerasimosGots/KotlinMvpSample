package com.app.kotlinmvpsample.presentation.feature.userList

import com.app.kotlinmvpsample.domain.useCase.UserUseCase
import com.app.kotlinmvpsample.presentation.base.presenter.BasePresenterImpl
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

/**
 * Created by Gerasimos on 20/11/2021
 *
 * The presenter has not knowledge of the view that request data
 */
class UserListFragmentPresenter
@Inject constructor(private val userUseCase: UserUseCase) :
    BasePresenterImpl<UserListFragmentContract.View>(),
    UserListFragmentContract.Presenter {

    /**
     * View requested Data
     *
     * To fetch the requested data we use the UserUseCase (that is injected in class's constructor).
     * The UseCase in responsible for fetching a stream of mapped data that then we observe
     * and return to the view with usage of view interface.
     */
    override fun requestData() {
        userUseCase.getUserList()
            // The stream started (an object subscribed to the stream) Show Loading
            .doOnSubscribe { view?.showLoading() }
            // The stream ended Hide Loading
            .doAfterTerminate { view?.dismissLoading() }
            .subscribeBy(
                // Success of the subscription. If there wasn't thrown a error or exception
                // (In network request of the data or in theta mapping of data)
                onSuccess = { userModelList ->
                    // With tha usage of view we return the requested data the View
                    view?.onUserListFetched(UIUserModelList = userModelList.toUserListModel())
                },
                // There was a Error or Exception
                onError = {
                    it.printStackTrace()
                }
            )
            // We add the stream (compositeDisposable) to the CompositeDisposable object
            // so we do not have a memory leak
            .addTo(compositeDisposable = compositeDisposable)
    }

    /**
     * Set a selected user in th UseCase
     * @param id of type String
     */
    override fun onUserSelected(id: String) {
        userUseCase.selectedUser(id = id)
    }
}