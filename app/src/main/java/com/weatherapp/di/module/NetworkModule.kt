package com.weatherapp.di.module

import com.squareup.picasso.Picasso
import com.weatherapp.api.config.ApiConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providePicasso(): Picasso = Picasso.get()

    @Provides
    @Singleton
    fun provideRetrofit(apiConfig: ApiConfig): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(apiConfig.getApiBaseUrl())
        .build()
}
