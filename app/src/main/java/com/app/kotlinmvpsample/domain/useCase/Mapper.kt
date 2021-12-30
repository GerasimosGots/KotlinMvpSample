package com.app.kotlinmvpsample.domain.useCase

import com.app.kotlinmvpsample.domain.model.ApiUserModel

/**
 * Created by Gerasimos on 6/12/2021
 */
fun ApiUserModel.toUserModel(photoUrl: String = ""): UserModel {
    return UserModel(
        id = this.id,
        email = this.email,
        userName = this.userName,
        phone = this.phone,
        photoUrl = photoUrl
    )
}