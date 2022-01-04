package com.app.kotlinmvpsample.presentation.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
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

    abstract val bindingInflater: (LayoutInflater) -> VB
    private var _binding: ViewBinding? = null
    protected val binding: VB
        get() = _binding as VB

    abstract fun onCreateView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_KotlinMvpSample)

        _binding = bindingInflater.invoke(layoutInflater)
        _binding?.let {
            setContentView(it.root)
            onCreateView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}