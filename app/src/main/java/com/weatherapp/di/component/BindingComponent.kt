package com.weatherapp.di.component

import com.weatherapp.di.scope.BindingScoped
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

@BindingScoped
@DefineComponent(parent = SingletonComponent::class)
interface BindingComponent
