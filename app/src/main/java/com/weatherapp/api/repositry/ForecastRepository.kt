package com.weatherapp.api.repositry

import com.weatherapp.api.model.ForecastDto
import io.reactivex.rxjava3.core.Single

interface ForecastRepository {

    fun getDailyForecast(latitude: Float, longitude: Float): Single<ForecastDto>
}
