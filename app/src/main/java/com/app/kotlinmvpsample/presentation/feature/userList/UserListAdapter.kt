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
class UserListAdapter constructor(private val weakListener: WeakReference<UserListFragmentContract.Adapter?>?) :
    BaseAdapter<UserListModel>() {

    override fun createItemViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(inflate(R.layout.list_item, parent))

    inner class ViewHolder(override val containerView: View) : BaseViewHolder(containerView) {
        override fun onBindData(item: UserListModel?) {
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