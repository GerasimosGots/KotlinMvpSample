package com.app.kotlinmvpsample.presentation.feature.userDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.databinding.FragmentUserDetailsBinding
import com.app.kotlinmvpsample.di.component.ui.DaggerUserDetailsComponent
import com.app.kotlinmvpsample.di.module.ui.UserDetailsModule
import com.app.kotlinmvpsample.domain.model.ui.CustomToolbarModel
import com.app.kotlinmvpsample.domain.useCase.UserModel
import com.app.kotlinmvpsample.presentation.base.fragment.BaseMvpFragment
import com.app.kotlinmvpsample.presentation.presentationExtension.loadImageWithBottomCorners
import com.app.kotlinmvpsample.presentation.view.CustomToolbar
import java.lang.ref.WeakReference

/**
 * Created by Gerasimos on 27/11/2021
 */
class UserDetailsFragment :
    BaseMvpFragment<FragmentUserDetailsBinding, UserDetailsContract.View, UserDetailsContract.Presenter>(),
    UserDetailsContract.View, CustomToolbar.BackButtonListener {

   override fun injectDependencies() {
        DaggerUserDetailsComponent.builder()
            .applicationComponent(app?.getApplicationComponent())
            .userDetailsModule(UserDetailsModule())
            .build()
            .inject(this)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ) = FragmentUserDetailsBinding.inflate(inflater, container, false)

    override fun onViewCreated() {
        presenter?.requestSelectedUser()
    }

    override fun initView() {
        binding?.toolbarView?.setListener(WeakReference(this))

        binding?.ctaButtonView?.setOnClickListener {
            context?.let {
                Toast.makeText(it, R.string.toast_text, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun setToolbar() {
        val model = CustomToolbarModel(R.string.user_details_title, true)
        binding?.toolbarView?.setView(model)
    }

    override fun onBackButtonCLickListener() {
        activity?.onBackPressed()
    }

    override fun onUserModelFetched(UserModel: UserModel) {
        setView(userModel = UserModel)
    }

    private fun setView(userModel: UserModel) {
        binding?.apply {
            coverImageView.loadImageWithBottomCorners(userModel.photoUrl)
            userNameTextView.text = userModel.userName
            emailTextView.text = userModel.email
            phoneTextView.text = userModel.phone
            ctaButtonView.text = String.format(getString(R.string.cta_text), userModel.userName)
        }
    }
}