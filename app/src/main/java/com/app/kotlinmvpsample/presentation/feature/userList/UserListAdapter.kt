package com.app.kotlinmvpsample.presentation.feature.userList

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.kotlinmvpsample.databinding.ListItemBinding
import com.app.kotlinmvpsample.presentation.base.BaseAdapter
import com.app.kotlinmvpsample.presentation.presentationExtension.loadImage
import java.lang.ref.WeakReference

/**
 * Created by Gerasimos on 27/11/2021
 */
class UserListAdapter : BaseAdapter<UIUserListModel>() {

    private var weakListener: WeakReference<UserListFragmentContract.Adapter?>? = null

    /**
     * Sets tha listener interface
     * @param weakListener WeakReference<UserListFragmentContract.Adapter>
     */
    fun setListener(weakListener: WeakReference<UserListFragmentContract.Adapter?>?) {
        this.weakListener = weakListener
    }

    // This method takes an instance of a ViewHolder with our inflated layout
    override fun createItemViewHolder(parent: ViewGroup, viewType: Int) : BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(itemBinding)
    }

    inner class ViewHolder(private val binding: ListItemBinding) : BaseViewHolder(binding) {

        // We bind the layout with our model
        override fun onBindData(item: UIUserListModel?) {
            binding.apply {

                coverImageView.loadImage(url = item?.coverImage ?: "")
                descriptionTextView.text = item?.description ?: ""

                // Click Listener
                cardViewContainer.setOnClickListener {
                    item?.let {
                        weakListener?.get()?.onCardListClicked(id = it.id)
                    }
                }
            }
        }
    }
}