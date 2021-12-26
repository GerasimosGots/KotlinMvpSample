package com.app.kotlinmvpsample.presentation.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.kotlinmvpsample.R

/**
 * Created by Gerasimos on 11/12/2021
 */
class FakeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_details, container, false);
    }

    companion object{
        fun newInstance() = FakeFragment()
    }

}