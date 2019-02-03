package com.vsahin.databindingexample

import com.vsahin.databindingexample.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import androidx.databinding.DataBindingUtil
import com.vsahin.databindingexample.di.component.AppComponent
import com.vsahin.databindingexample.di.component.DaggerBindingComponent


class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationInjector = DaggerAppComponent.builder().create(this)

        val bindingComponent =
            DaggerBindingComponent.builder().appComponent(applicationInjector as AppComponent?).build()
        DataBindingUtil.setDefaultComponent(bindingComponent)

        return applicationInjector
    }
}