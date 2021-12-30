package com.app.kotlinmvpsample.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Gerasimos on 21/11/2021
 */

@Parcelize
data class ApiUserModel(
    @SerializedName("id")
    val id: String,

    @SerializedName("username")
    val userName: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("phone")
    val phone: String
) : Parcelable