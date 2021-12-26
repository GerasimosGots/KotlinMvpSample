package com.app.kotlinmvpsample.presentation.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by Gerasimos on 27/11/2021
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun onCreateView()
    abstract fun getLayoutViewBinding(): ViewBinding?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = getLayoutViewBinding()?.root
        view?.let {
            setContentView(view)
            onCreateView()
        }
    }
}