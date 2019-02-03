package com.vsahin.databindingexample.ui.binding

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import javax.inject.Inject

class ImageBindingAdapter @Inject constructor(){
    @BindingAdapter("strike")
    fun strike(view: TextView, strike: Boolean) {
        if (strike) {
            view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            view.paintFlags = Paint.ANTI_ALIAS_FLAG
        }
    }
}