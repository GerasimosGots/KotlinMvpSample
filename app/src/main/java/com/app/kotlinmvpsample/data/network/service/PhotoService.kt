package com.app.kotlinmvpsample.data.network.service

import com.app.kotlinmvpsample.domain.model.ApiPhotoModel
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Gerasimos on 6/12/2021
 */
interface PhotoService {
    @FormUrlEncoded
    @POST("/id")
    fun getPhotoById(@Field("image") photoId: String): Single<ApiPhotoModel>
}