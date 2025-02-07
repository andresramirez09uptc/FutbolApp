package com.task.futbolapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadCircleImage(url: String) {
    Glide
        .with(this)
        .applyDefaultRequestOptions(RequestOptions().circleCrop())
        .load(url)
        .into(this)
}

fun ImageView.loadCircleImage(resourceId: Int) {
    Glide
        .with(this)
        .applyDefaultRequestOptions(RequestOptions().circleCrop())
        .load(resourceId)
        .into(this)
}

fun ImageView.loadImage(url: String) {
    Glide
        .with(this)
        .load(url)
        .into(this)
}