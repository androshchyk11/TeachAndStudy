package com.example.ts.view.adapters.binder

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageFromId")
fun ImageView.setImageFromId(imageDrawable: Drawable?) {
    if (imageDrawable != null) {
        Glide
            .with(this.context)
            .load(imageDrawable)
            .into(this)
    }
}