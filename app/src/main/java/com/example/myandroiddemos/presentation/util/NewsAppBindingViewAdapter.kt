package com.example.myandroiddemos.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImg")
fun ImageView.loadUrlIntoImageView(url : String){
    Glide.with(this.context)
        .load(url)
        .into(this)
}