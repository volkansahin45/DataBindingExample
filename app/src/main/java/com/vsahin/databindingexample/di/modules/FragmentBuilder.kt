package com.vsahin.databindingexample.di.modules

import com.vsahin.databindingexample.di.scope.FragmentScope
import com.vsahin.databindingexample.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment
}
