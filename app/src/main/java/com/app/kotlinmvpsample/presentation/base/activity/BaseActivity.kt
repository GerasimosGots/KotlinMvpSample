package com.app.kotlinmvpsample.presentation.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.R

/**
 * Created by Gerasimos on 27/11/2021
 *
 * This activity class extends the the native of the system [AppCompatActivity].
 * This class used only as extension of other class and need a generic parameter of [ViewBinding]
 * This class is responsible the view inflation/binding.
 *  - Has an abstract property that needs to return an instance of [ViewBinding]
 *
 * The ViewBinding implementation that is been used in Activity and Fragment,
 * is done based on the following post -> https://chetangupta.net/viewbinding/
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected var binding: VB? = null

    abstract fun getActivityBinding(inflater: LayoutInflater): VB

    private var _binding: ViewBinding? = null

    protected val navController by lazy {
        getNavHostFragment().navController
    }

    abstract fun getNavHostFragment(): NavHostFragment

    abstract fun onViewCreated()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_KotlinMvpSample)
        super.onCreate(savedInstanceState)

        binding = getActivityBinding(layoutInflater)
        setContentView(binding?.root)
        onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}