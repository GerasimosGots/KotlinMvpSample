package com.app.kotlinmvpsample.presentation.presentationExtension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

/**
 * Created by Gerasimos on 6/12/2021
 */
fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .transform(CenterCrop(), RoundedCorners(60))
        //.placeholder(R.drawable.ic_camp_placeholder_secondary)
        .into(this)
}