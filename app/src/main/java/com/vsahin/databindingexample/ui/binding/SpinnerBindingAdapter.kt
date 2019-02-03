package com.vsahin.databindingexample.ui.binding

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import javax.inject.Inject

class SpinnerBindingAdapter @Inject constructor() {
    @BindingAdapter("app:onItemSelected")
    fun setOnItemSelectedListener(spinner: Spinner, myOnItemSelectedListener: MyOnItemSelectedListener) {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                myOnItemSelectedListener.onSelected(parent?.getItemAtPosition(position), position)
            }

        }
    }
}

interface MyOnItemSelectedListener {
    fun onSelected(item: Any?, position: Int)
}