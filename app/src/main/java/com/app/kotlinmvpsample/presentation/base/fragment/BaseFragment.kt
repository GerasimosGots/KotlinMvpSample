package com.app.kotlinmvpsample.presentation.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.domain.model.ui.FragmentInflateModel

/**
 * Created by Gerasimos on 25/11/2021
 */
abstract class BaseFragment : Fragment() {

    private var binding: ViewBinding? = null

    abstract fun getLayoutBinding(fragmentInflateModel: FragmentInflateModel): ViewBinding

    abstract fun onCreateView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val fragmentInflateModel = provideFragmentInflateModel(inflater, container, false)

        getLayoutBinding(fragmentInflateModel).apply {
            binding = this
            return this.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateView()
    }

    private fun provideFragmentInflateModel(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ): FragmentInflateModel {
        return FragmentInflateModel(
            inflater = inflater,
            container = container,
            attachToParent = attachToParent
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}