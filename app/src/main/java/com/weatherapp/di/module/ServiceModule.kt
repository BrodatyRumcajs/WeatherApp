package com.weatherapp.di.module

import com.weatherapp.api.service.ForecastService
import com.weatherapp.api.service.SearchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideSearchService(retrofit: Retrofit): SearchService =
        retrofit.create(SearchService::class.java)

    @Provides
    fun provideForecastService(retrofit: Retrofit): ForecastService =
        retrofit.create(ForecastService::class.java)
}
