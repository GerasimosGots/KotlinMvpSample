package com.app.kotlinmvpsample.presentation.feature

import android.view.LayoutInflater
import androidx.navigation.fragment.NavHostFragment
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.databinding.ActivityUserBinding
import com.app.kotlinmvpsample.presentation.base.activity.BaseActivity

/**
 * Created by Gerasimos on 20/11/2021
 */
class UserActivity : BaseActivity<ActivityUserBinding>() {

    override fun getActivityBinding(inflater: LayoutInflater) = ActivityUserBinding.inflate(layoutInflater)

    override fun onViewCreated() {}

    override fun getNavHostFragment(): NavHostFragment {
       return supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
    }
}