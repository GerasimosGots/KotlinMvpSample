package com.app.kotlinmvpsample.data.network.service

import com.app.kotlinmvpsample.domain.model.ApiUserModel
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Gerasimos on 25/11/2021
 */
interface UserService {
    @GET("/users")
    fun getUsers(): Single<MutableList<ApiUserModel>>
}