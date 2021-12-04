package com.weatherapp.di.module

import com.weatherapp.api.repositry.ForecastRepository
import com.weatherapp.api.repositry.ForecastRepositoryImpl
import com.weatherapp.api.repositry.SearchRepository
import com.weatherapp.api.repositry.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    @Binds
    @ViewModelScoped
    abstract fun bindForecastRepository(impl: ForecastRepositoryImpl): ForecastRepository
}
