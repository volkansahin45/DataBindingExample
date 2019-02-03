package com.vsahin.databindingexample.di.component;

import androidx.databinding.DataBindingComponent;
import com.vsahin.databindingexample.di.modules.BindingModule;
import com.vsahin.databindingexample.di.scope.DataBinding;
import dagger.Component;

@DataBinding
@Component(dependencies = AppComponent.class, modules = BindingModule.class)
public interface BindingComponent extends DataBindingComponent {
}
