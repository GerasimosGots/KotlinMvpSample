package com.app.kotlinmvpsample.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Gerasimos on 6/12/2021
 */

@Parcelize
data class ApiPhotoModel(
    @SerializedName("image")
    val photoUrl: String
) : Parcelable