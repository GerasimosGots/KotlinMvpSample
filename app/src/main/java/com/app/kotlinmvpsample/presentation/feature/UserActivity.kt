package com.app.kotlinmvpsample.presentation.feature

import android.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.databinding.ActivityUserBinding
import com.app.kotlinmvpsample.presentation.base.activity.BaseActivity
import dagger.android.AndroidInjector

/**
 * Created by Gerasimos on 20/11/2021
 */
class UserActivity : BaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityUserBinding

    private val navController by lazy { findNavController(R.id.fragment_container_view) }

    override fun getLayoutViewBinding(): ViewBinding? {
        binding = ActivityUserBinding.inflate(layoutInflater)
        return binding
    }

    override fun onCreateView() {
        setSupportActionBar(binding.toolbar)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}