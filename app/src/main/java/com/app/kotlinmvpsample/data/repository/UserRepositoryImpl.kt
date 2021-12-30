package com.app.kotlinmvpsample.data.repository

import com.app.kotlinmvpsample.data.network.ApiClient
import com.app.kotlinmvpsample.data.network.SchedulerProvider
import com.app.kotlinmvpsample.data.network.service.UserService
import com.app.kotlinmvpsample.domain.model.ApiUserModel
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Gerasimos on 21/11/2021
 */
class UserRepositoryImpl @Inject constructor(
    private val provider: SchedulerProvider,
    private val userService: UserService
) : UserRepository {

    override fun getUserList(): Single<MutableList<ApiUserModel>> {
        return userService.getUsers()
            .observeOn(provider.ui())
            .subscribeOn(provider.io())
    }

    override fun getPhotoById(id: String): String {
        return getMockImagesById(photoId = id)

    }

    private fun getMockImagesById(photoId: String): String {
        val photoUrl = ApiClient.SECONDARY_URL
            .plus(photoId)
            .plus("/800/900")
        return photoUrl
    }
}