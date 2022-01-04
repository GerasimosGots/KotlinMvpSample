package com.app.kotlinmvpsample.presentation.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    private var _binding: ViewBinding? = null
    protected val binding: VB
        get() = _binding as VB

    abstract fun setToolbar()

    abstract fun onCreateView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return _binding?.root ?: kotlin.run { view }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateView()
        setToolbar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}