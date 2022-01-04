package com.app.kotlinmvpsample.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.databinding.LayoutCustomToolbarBinding
import com.app.kotlinmvpsample.domain.model.ui.CustomToolbarModel
import com.app.kotlinmvpsample.presentation.presentationExtension.visible
import java.lang.ref.WeakReference

/**
 * Created by Gerasimos on 30/12/2021
 *
 *  Custom Toolbar that imitates the native Toolbar.
 *  This view extends the FrameLayout and inflates a custom layout.
 */
class CustomToolbar(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private val toolbarBinding: LayoutCustomToolbarBinding by lazy {
        LayoutCustomToolbarBinding.inflate(LayoutInflater.from(context), this, false)
    }
    private var listener: WeakReference<BackButtonListener?>? = null

    init {
        addView(toolbarBinding.root)

        val attributeArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar)
        setTitle(attributeArray.getString(R.styleable.CustomToolbar_title) ?: "")
        attributeArray.recycle()
        toolbarBinding.backButtonView.setOnClickListener {
            listener?.get()?.onBackButtonCLickListener()
        }
    }

    /**
     * Sets a weak reference of BackButtonListener interface BackButtonListener
     * @param listener of type WeakReference<BackButtonListener>
     */
    fun setListener(listener: WeakReference<BackButtonListener?>?) {
        this.listener = listener
    }

    /**
     * Provide a CustomToolbarModel to set the view of CustomToolbar
     * @param customToolbarModel of type [CustomToolbarModel]
     */
    fun setView(customToolbarModel: CustomToolbarModel) {
        toolbarBinding.titleTextView.text = context?.getString(customToolbarModel.title) ?: ""
        toolbarBinding.backButtonView.visible(customToolbarModel.enableBackButton)
    }

    /**
     * Sets the Toolbar title
     * @param title of type String
     */
    fun setTitle(title: String) {
        toolbarBinding.titleTextView.text = title
        toolbarBinding.titleTextView.setTextAppearance(R.style.Toolbar_TextStyle)
    }

    /**
     * Custom toolbar interface for on back button click listener
     */
    interface BackButtonListener {
        fun onBackButtonCLickListener()
    }
}