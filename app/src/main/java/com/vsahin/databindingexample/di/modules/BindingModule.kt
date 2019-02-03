package com.vsahin.databindingexample.di.modules

import com.vsahin.databindingexample.di.scope.DataBinding
import com.vsahin.databindingexample.ui.binding.ImageBindingAdapter
import com.vsahin.databindingexample.ui.binding.SpinnerBindingAdapter
import dagger.Module
import dagger.Provides

@Module
class BindingModule {
    @DataBinding
    @Provides
    fun provideImageBindingAdapter(): ImageBindingAdapter {
        return ImageBindingAdapter()
    }

    @DataBinding
    @Provides
    fun provideSpinnerBindingAdapter(): SpinnerBindingAdapter{
        return SpinnerBindingAdapter()
    }
}
