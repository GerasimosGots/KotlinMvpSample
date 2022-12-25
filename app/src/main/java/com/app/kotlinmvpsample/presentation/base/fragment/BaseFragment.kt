package com.app.kotlinmvpsample.presentation.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

/**
 * Created by Gerasimos on 25/11/2021
 *
 * This fragment class extends the the native of the system [Fragment].
 * This class used only as extension of other class and need a generic parameter of [ViewBinding]
 * This class is responsible the view inflation/binding.
 *  - Has an abstract property that needs to return an instance of [ViewBinding]
 *
 * The ViewBinding implementation that is been used in Activity and Fragment,
 * is done based on the following post -> https://chetangupta.net/viewbinding/
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected var binding: VB? = null

    protected abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun setToolbar()

    abstract fun onViewCreated()

    protected abstract fun initView()

    // Nav controller, lazy init, Usage for all fragment children, for the navigation
    protected val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreated()
        initView()
        setToolbar()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}