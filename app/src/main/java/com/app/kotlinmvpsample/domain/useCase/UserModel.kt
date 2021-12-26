package com.app.kotlinmvpsample.domain.useCase

/**
 * Created by Gerasimos on 6/12/2021
 */
data class UserModel(
    val id: String,
    val userName: String,
    val email: String,
    val phone: String,
    val photoUrl : String
)