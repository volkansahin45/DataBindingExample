package com.vsahin.databindingexample.di.modules

import androidx.lifecycle.ViewModel
import com.vsahin.databindingexample.di.ViewModelKey
import com.vsahin.databindingexample.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}