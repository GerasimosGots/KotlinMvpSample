package com.app.kotlinmvpsample.presentation.feature.userDetails

import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.databinding.FragmentUserDetailsBinding
import com.app.kotlinmvpsample.domain.model.ui.FragmentInflateModel
import com.app.kotlinmvpsample.domain.useCase.UserModel
import com.app.kotlinmvpsample.presentation.base.fragment.BaseMvpFragment
import com.app.kotlinmvpsample.presentation.presentationExtension.loadImage
import kotlinx.android.synthetic.main.fragment_user_details.view.*
import javax.inject.Inject

/**
 * Created by Gerasimos on 27/11/2021
 */
class UserDetailsFragment :
    BaseMvpFragment<UserDetailsContract.View, UserDetailsContract.Presenter>(),
    UserDetailsContract.View {

    lateinit var userDetailsBinding: FragmentUserDetailsBinding

    @Inject
    lateinit var userDetailsPresenter: UserDetailsPresenter

    override fun injectDependencies(): UserDetailsContract.Presenter = userDetailsPresenter

    override fun getLayoutBinding(fragmentInflateModel: FragmentInflateModel): ViewBinding {
        return FragmentUserDetailsBinding.inflate(
            fragmentInflateModel.inflater,
            fragmentInflateModel.container,
            fragmentInflateModel.attachToParent
        )
    }

    override fun onCreateView() {
        presenter?.requestSelectedUser()
        userDetailsBinding.toolbarView.title = getString(R.string.user_details_toolbar)
    }

    private fun setView(userModel: UserModel) {
        userDetailsBinding.coverImageView.loadImage(userModel.photoUrl)
        userDetailsBinding.coverImageView.descriptionTextView.text = userModel.userName
    }

    override fun onUserModelFetched(userModel: UserModel) {
        setView(userModel = userModel)
    }
}