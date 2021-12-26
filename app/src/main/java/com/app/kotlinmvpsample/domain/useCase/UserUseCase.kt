package com.app.kotlinmvpsample.domain.useCase

import io.reactivex.Single

/**
 * Created by Gerasimos on 21/11/2021
 */
interface UserUseCase {
    fun getUserList(): Single<MutableList<UserModel>>

    fun selectedUser(id: String)

    fun getSelectedUser() : Single<UserModel>
}