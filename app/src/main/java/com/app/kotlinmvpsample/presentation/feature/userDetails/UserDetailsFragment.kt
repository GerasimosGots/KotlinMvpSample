package com.app.kotlinmvpsample.presentation.feature.userDetails

import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.databinding.FragmentUserDetailsBinding
import com.app.kotlinmvpsample.di.component.ui.DaggerUserDetailsComponent
import com.app.kotlinmvpsample.di.module.ui.UserDetailsModule
import com.app.kotlinmvpsample.domain.model.ui.CustomToolbarModel
import com.app.kotlinmvpsample.domain.model.ui.FragmentInflateModel
import com.app.kotlinmvpsample.domain.useCase.UserModel
import com.app.kotlinmvpsample.presentation.base.fragment.BaseMvpFragment
import com.app.kotlinmvpsample.presentation.presentationExtension.loadImageWithBottomCorners
import com.app.kotlinmvpsample.presentation.view.CustomToolbar
import java.lang.ref.WeakReference

/**
 * Created by Gerasimos on 27/11/2021
 */
class UserDetailsFragment :
    BaseMvpFragment<UserDetailsContract.View, UserDetailsContract.Presenter>(),
    UserDetailsContract.View, CustomToolbar.BackButtonListener {

    private lateinit var userDetailsBinding: FragmentUserDetailsBinding

    override fun injectDependencies() {
        DaggerUserDetailsComponent.builder()
            .applicationComponent(app?.getApplicationComponent())
            .userDetailsModule(UserDetailsModule())
            .build()
            .inject(this)
    }

    override fun getLayoutBinding(fragmentInflateModel: FragmentInflateModel): ViewBinding {
        userDetailsBinding = FragmentUserDetailsBinding.inflate(
            fragmentInflateModel.inflater,
            fragmentInflateModel.container,
            fragmentInflateModel.attachToParent
        )
        return userDetailsBinding
    }

    override fun onCreateView() {
        presenter?.requestSelectedUser()
    }

    override fun setToolbar() {
        val model = CustomToolbarModel(R.string.user_details_title, true)
        userDetailsBinding.toolbarView.setView(model)
    }

    override fun onBackButtonCLickListener() {
        activity?.onBackPressed()
    }

    override fun onUserModelFetched(UserModel: UserModel) {
        setView(UserModel = UserModel)
    }

    private fun setView(UserModel: UserModel) {
        userDetailsBinding.coverImageView.loadImageWithBottomCorners(UserModel.photoUrl)
        userDetailsBinding.userNameTextView.text = UserModel.userName
        userDetailsBinding.emailTextView.text = UserModel.email
        userDetailsBinding.phoneTextView.text = UserModel.phone
        userDetailsBinding.ctaButtonView.text = String.format(getString(R.string.cta_text), UserModel.userName)
        userDetailsBinding.toolbarView.setListener(WeakReference(this))

        userDetailsBinding.ctaButtonView.setOnClickListener {
            context?.let {
                Toast.makeText(it, R.string.toast_text, Toast.LENGTH_LONG).show()
            }
        }
    }
}