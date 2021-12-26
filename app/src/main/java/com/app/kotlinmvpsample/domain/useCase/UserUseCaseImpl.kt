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
        return userRepository.getUserList()
            .flatMap { apiUserModelList ->
                val userModelList: MutableList<UserModel> = mutableListOf()
                apiUserModelList.map { apiUserModel ->
                    userRepository.getPhotoById(apiUserModel.id).map {
                        val model = apiUserModel.toUserModel(photo = it.photoUrl)
                        userModelList.add(model)
                    }
                }
                addToCache(userModelList)
                Single.just(userModelList)
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

    private fun addToCache(userModelList: MutableList<UserModel>) {
        cachedUserModelList.addAll(userModelList)
    }

    private fun clearCache() {
        cachedUserModelList.clear()
        selectedUserId = null
    }
}