package com.weatherapp.di.component

import dagger.hilt.DefineComponent

@DefineComponent.Builder
interface BindingComponentBuilder {
    fun build(): BindingComponent
}
