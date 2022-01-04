package com.app.kotlinmvpsample.presentation.feature

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.databinding.ActivityUserBinding
import com.app.kotlinmvpsample.presentation.base.activity.BaseActivity

/**
 * Created by Gerasimos on 20/11/2021
 */
class UserActivity : BaseActivity<ActivityUserBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityUserBinding = ActivityUserBinding::inflate

    override fun onCreateView() {

    }
}