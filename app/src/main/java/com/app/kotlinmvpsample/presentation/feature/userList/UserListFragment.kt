package com.app.kotlinmvpsample.presentation.feature.userList

import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.databinding.FragmentUserListBinding
import com.app.kotlinmvpsample.domain.model.ui.FragmentInflateModel
import com.app.kotlinmvpsample.presentation.base.fragment.BaseMvpFragment
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by Gerasimos on 27/11/2021
 */
class UserListFragment :
    BaseMvpFragment<UserListFragmentContract.View, UserListFragmentContract.Presenter>(),
    UserListFragmentContract.View,
    UserListFragmentContract.Adapter {

    // Layout Manager
    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private val userListAdapter: UserListAdapter by lazy {
        UserListAdapter(WeakReference(this))
    }

    @Inject
    lateinit var userListFragmentPresenter: UserListFragmentContract.Presenter

    private lateinit var featureListBinding: FragmentUserListBinding

    override fun injectDependencies() = userListFragmentPresenter

    override fun getLayoutBinding(fragmentInflateModel: FragmentInflateModel): ViewBinding {
        featureListBinding = FragmentUserListBinding.inflate(
            fragmentInflateModel.inflater,
            fragmentInflateModel.container,
            fragmentInflateModel.attachToParent)
        return featureListBinding
    }

    override fun onCreateView() {
        presenter?.requestData()
        featureListBinding.toolbarView.title = getString(R.string.user_list_toolbar)
    }

    override fun onUserListFetched(userModelList: MutableList<UserListModel>) {
        initAdapter()
        userListAdapter.setNotOptional(userModelList)
    }

    override fun onCardListClicked(id: String) {
        presenter?.onUserSelected(id = id)

        // Navigate to next
        findNavController(this).navigate(R.id.action_UserList_to_UserDetails)
    }

    private fun initAdapter() {
        featureListBinding.userRecyclerView.also {
            it.adapter = userListAdapter
            it.layoutManager = layoutManager
        }
    }

    companion object{
        fun newInstance() : UserListFragment = UserListFragment()
    }
}