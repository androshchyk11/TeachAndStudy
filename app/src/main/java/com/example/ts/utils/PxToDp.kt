package com.example.ts.utils

import android.content.Context
import kotlin.math.roundToInt

fun Context.pxToDp(px: Int): Int {
    val density: Float = resources.displayMetrics.density
    return (px.toFloat() * density).roundToInt()
}

fun Context.pxToDp(px: Float): Float {
    val density: Float = resources.displayMetrics.density
    return (px * density)
}