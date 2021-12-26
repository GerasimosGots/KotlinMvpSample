package com.app.kotlinmvpsample.presentation.feature.userList

import com.app.kotlinmvpsample.domain.useCase.UserModel

/**
 * Created by Gerasimos on 6/12/2021
 */

fun MutableList<UserModel>.toUserListModel(): MutableList<UserListModel> {
    val list: MutableList<UserListModel> = mutableListOf()
    this.map {
        val userListMode = UserListModel(
            id = it.id,
            description = it.userName,
            coverImage = it.photoUrl
        )
        list.add(userListMode)
    }
    return list
}