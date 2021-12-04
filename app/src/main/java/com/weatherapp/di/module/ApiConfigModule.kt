package com.weatherapp.di.module

import com.weatherapp.api.config.ApiConfig
import com.weatherapp.api.config.ApiConfigImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiConfigModule {

    @Binds
    @Singleton
    abstract fun bindApiConfig(impl: ApiConfigImpl): ApiConfig
}
