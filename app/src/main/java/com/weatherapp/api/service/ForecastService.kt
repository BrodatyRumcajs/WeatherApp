package com.weatherapp.api.service

import com.weatherapp.api.model.ForecastDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {

    @GET("data/2.5/onecall")
    fun getDailyForecast(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("units") units: String,
        @Query("exclude") exclude: String,
        @Query("appid") apiKey: String
    ): Single<ForecastDto>
}
