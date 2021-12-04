package com.weatherapp.di.component

import androidx.databinding.DataBindingComponent
import com.weatherapp.adapter.binding.ImageViewBindingAdapter
import com.weatherapp.di.scope.BindingScoped
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@EntryPoint
@BindingScoped
@InstallIn(BindingComponent::class)
interface DataBindingEntryPoint: DataBindingComponent {

    @BindingScoped
    override fun getImageViewBindingAdapter() : ImageViewBindingAdapter
}
