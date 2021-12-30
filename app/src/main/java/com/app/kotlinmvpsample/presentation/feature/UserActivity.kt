package com.app.kotlinmvpsample.presentation.feature

import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.databinding.ActivityUserBinding
import com.app.kotlinmvpsample.presentation.base.activity.BaseActivity

/**
 * Created by Gerasimos on 20/11/2021
 */
class UserActivity : BaseActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun getLayoutViewBinding(): ViewBinding {
        binding = ActivityUserBinding.inflate(layoutInflater)
        return binding
    }

    override fun onCreateView() {
    }
}