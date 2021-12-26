package com.app.kotlinmvpsample.data.repository

import com.app.kotlinmvpsample.domain.model.ApiPhotoModel
import com.app.kotlinmvpsample.domain.model.ApiUserModel
import io.reactivex.Single

/**
 * Created by Gerasimos on 21/11/2021
 */
interface UserRepository {
    fun getUserList(): Single<MutableList<ApiUserModel>>

    fun getPhotoById(id: String): Single<ApiPhotoModel>
}