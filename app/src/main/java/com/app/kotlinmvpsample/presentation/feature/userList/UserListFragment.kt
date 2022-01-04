package com.app.kotlinmvpsample.presentation.feature.userList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.databinding.FragmentUserListBinding
import com.app.kotlinmvpsample.di.component.ui.DaggerUserListFragmentComponent
import com.app.kotlinmvpsample.di.module.ui.UserListModule
import com.app.kotlinmvpsample.domain.model.ui.CustomToolbarModel
import com.app.kotlinmvpsample.domain.model.ui.FragmentInflateModel
import com.app.kotlinmvpsample.presentation.base.fragment.BaseMvpFragment
import com.app.kotlinmvpsample.presentation.presentationExtension.visible
import java.lang.ref.WeakReference

/**
 * Created by Gerasimos on 27/11/2021
 *
 * The View has not knowledge of the presenter that it will request data
 */
class UserListFragment :
    BaseMvpFragment<FragmentUserListBinding, UserListFragmentContract.View, UserListFragmentContract.Presenter>(),
    UserListFragmentContract.View,
    UserListFragmentContract.Adapter {

    // Lazy initialization of the UserListAdapter
    private val userListAdapter: UserListAdapter by lazy {
        UserListAdapter()
    }

    /**
     * In this abstract function we initialize the dependant dagger module
     * so we can inject the presenter in this view
     *
     * -- More info in  the Dagger Modules
     */
    override fun injectDependencies() {
        DaggerUserListFragmentComponent.builder()
            .applicationComponent(app?.getApplicationComponent())
            .userListModule(UserListModule())
            .build()
            .inject(this)
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUserListBinding = FragmentUserListBinding::inflate

    override fun setToolbar() {
        val model = CustomToolbarModel(R.string.user_list_title, false)
        binding.toolbarView.setView(model)
    }

    /**
     * Enables Loader
     */
    override fun showLoading() {
        binding.loaderView.visible(true)
    }

    /**
     * Dismiss Loader
     */
    override fun dismissLoading() {
        binding.loaderView.visible(false)
    }

    override fun onCreateView() {
        presenter?.requestData()
    }

    /**
     * We fetched the list of Users from presenter
     * @param UIUserModelList: MutableList<UIUserListModel> [UIUserListModel]
     */
    override fun onUserListFetched(UIUserModelList: MutableList<UIUserListModel>) {
        initAdapter()
        userListAdapter.set(UIUserModelList)
    }

    /**
     * Card Selected
     * @param id: String
     */
    override fun onCardListClicked(id: String) {
        presenter?.onUserSelected(id = id)

        // Navigate to next
        findNavController(this).navigate(R.id.action_UserList_to_UserDetails)
    }

    private fun initAdapter() {
        binding.userRecyclerView.also {
            it.adapter = userListAdapter
            it.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        userListAdapter.setListener(WeakReference(this))
    }
}