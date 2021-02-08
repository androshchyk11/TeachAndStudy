package com.example.ts.view.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ts.utils.pxToDp
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject


class SlideImageAdapter @Inject constructor(
    @ActivityContext private val context: Context
) : RecyclerView.Adapter<SlideImageAdapter.PagerVH>() {

    var listImage: ArrayList<String?> = arrayListOf()
    private lateinit var imageViewHolder: ImageView

    private fun generateSliderLay(context: Context): FrameLayout {
        context.apply {
            val frameLayout = FrameLayout(this)
            frameLayout.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            imageViewHolder = ImageView(context)
            val layParam = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                pxToDp(200)
            )
            layParam.setMargins(pxToDp(5), pxToDp(20), pxToDp(20), pxToDp(5))
            imageViewHolder.layoutParams = layParam

            frameLayout.addView(imageViewHolder)
            return frameLayout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(generateSliderLay(parent.context))

    override fun onBindViewHolder(holder: PagerVH, position: Int): Unit = holder.itemView.run {
        Glide
            .with(holder.itemView.context)
            .load(listImage[position])
            .into(imageViewHolder)
    }

    override fun getItemCount(): Int = listImage.size

    inner class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}