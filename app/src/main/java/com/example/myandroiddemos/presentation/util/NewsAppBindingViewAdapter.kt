package com.example.myandroiddemos.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImg")
fun ImageView.loadUrlIntoImageView(url : String?){

    if(url == null)
        return

    Glide.with(this.context)
        .load(url)
        .into(this)
}