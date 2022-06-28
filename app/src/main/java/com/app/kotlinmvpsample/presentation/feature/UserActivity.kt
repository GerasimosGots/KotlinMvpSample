package com.app.kotlinmvpsample.presentation.feature

import android.view.LayoutInflater
import com.app.kotlinmvpsample.databinding.ActivityUserBinding
import com.app.kotlinmvpsample.presentation.base.activity.BaseActivity

/**
 * Created by Gerasimos on 20/11/2021
 */
class UserActivity : BaseActivity<ActivityUserBinding>() {

    override fun getActivityBinding(inflater: LayoutInflater) = ActivityUserBinding.inflate(layoutInflater)


    override fun onViewCreated() {
    }

}