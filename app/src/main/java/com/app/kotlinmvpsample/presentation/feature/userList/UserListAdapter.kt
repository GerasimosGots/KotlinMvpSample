package com.app.kotlinmvpsample.presentation.feature.userList

import android.view.View
import android.view.ViewGroup
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.presentation.base.BaseAdapter
import com.app.kotlinmvpsample.presentation.presentationExtension.loadImage
import kotlinx.android.synthetic.main.list_item.view.*
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
    override fun createItemViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(inflate(R.layout.list_item, parent))

    inner class ViewHolder(override val containerView: View) : BaseViewHolder(containerView) {

        // We bind the layout with our model
        override fun onBindData(item: UIUserListModel?) {
            containerView.coverImageView?.loadImage(url = item?.coverImage ?: "")
            containerView.descriptionTextView?.text = item?.description ?: ""

            containerView.cardViewContainer?.setOnClickListener {
                item?.let {
                    weakListener?.get()?.onCardListClicked(id = it.id)
                }
            }
        }
    }
}