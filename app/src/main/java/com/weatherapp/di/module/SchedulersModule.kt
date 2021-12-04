package com.weatherapp.di.module

import com.weatherapp.di.qualifiers.BackgroundScheduler
import com.weatherapp.di.qualifiers.ForegroundScheduler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

@Module
@InstallIn(SingletonComponent::class)
class SchedulersModule {

    @BackgroundScheduler
    @Provides
    fun provideBackgroundScheduler(): Scheduler = Schedulers.io()

    @ForegroundScheduler
    @Provides
    fun provideForegroundScheduler(): Scheduler = AndroidSchedulers.mainThread()
}
