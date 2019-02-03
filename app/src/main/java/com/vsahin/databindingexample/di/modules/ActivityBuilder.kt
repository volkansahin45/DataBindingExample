package com.vsahin.databindingexample.di.modules

import com.vsahin.databindingexample.ui.MainActivity
import com.vsahin.databindingexample.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity
}
