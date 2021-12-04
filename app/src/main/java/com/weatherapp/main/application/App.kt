package com.weatherapp.main.application

import android.app.Application
import androidx.databinding.DataBindingUtil
import com.weatherapp.di.component.BindingComponentBuilder
import com.weatherapp.di.component.DataBindingEntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Provider

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var bindingComponentProvider: Provider<BindingComponentBuilder>

    override fun onCreate() {
        super.onCreate()
        val dataBindingComponent = bindingComponentProvider.get().build()
        val dataBindingEntryPoint = EntryPoints.get(
            dataBindingComponent,
            DataBindingEntryPoint::class.java
        )
        DataBindingUtil.setDefaultComponent(dataBindingEntryPoint)
    }
}
