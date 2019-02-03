package com.vsahin.databindingexample.di.modules

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.vsahin.databindingexample.MyApplication
import dagger.Binds
import dagger.Module

import javax.inject.Singleton

/**
 * Created by Volkan Şahin on 18.08.2017.
 */

@Module
abstract class AppModule {

    @Binds
    @Singleton
    internal abstract fun application(app: MyApplication): Application

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
