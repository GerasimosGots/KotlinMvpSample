package com.app.kotlinmvpsample.domain.model.ui

import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Gerasimos on 27/11/2021
 */
data class FragmentInflateModel(
    var inflater: LayoutInflater,
    var container: ViewGroup?,
    var attachToParent : Boolean
)
