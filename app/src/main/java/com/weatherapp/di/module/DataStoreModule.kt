package com.weatherapp.di.module

import com.weatherapp.datastore.SelectedCityStore
import com.weatherapp.datastore.SelectedCityStoreImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {

    @Binds
    @Singleton
    abstract fun bindSelectedCityStore(impl: SelectedCityStoreImpl): SelectedCityStore
}
