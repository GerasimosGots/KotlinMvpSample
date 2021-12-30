package com.app.kotlinmvpsample.domain.useCase

import com.app.kotlinmvpsample.data.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Gerasimos on 21/11/2021
 */
class UserUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    UserUseCase {

    private val cachedUserModelList: MutableList<UserModel> = mutableListOf()
    private var selectedUserId: String? = null

    override fun getUserList(): Single<MutableList<UserModel>> {
        clearCache()

        return userRepository.getUserList().map { userModelResponseList ->
            userModelResponseList.map { apiUserModel ->
                val photoUrl = userRepository.getPhotoById(apiUserModel.id)
                val userModel = apiUserModel.toUserModel(photoUrl = photoUrl)
                userModel
            }.toMutableList().also {
                addToCache(it)
            }
        }
    }

    override fun selectedUser(id: String) {
        selectedUserId = id
    }

    override fun getSelectedUser(): Single<UserModel> {
        if (cachedUserModelList.isEmpty()) {
            return Single.error(Throwable("List is Empty"))
        }

        val resultList = cachedUserModelList.filter { it.id == selectedUserId }
        return if (resultList.isNullOrEmpty()) {
            Single.error(Throwable("List is Empty"))
        } else {
            Single.just(resultList[0])
        }
    }

    private fun addToCache(UserModelList: MutableList<UserModel>) {
        cachedUserModelList.addAll(UserModelList)
    }

    private fun clearCache() {
        cachedUserModelList.clear()
        selectedUserId = null
    }
}