package com.weatherapp.api.repositry

import com.weatherapp.api.config.ApiConfig
import com.weatherapp.api.model.ForecastDto
import com.weatherapp.api.service.ForecastService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

private const val UNITS = "metric"
private const val EXCLUDE = "minutely,hourly,alerts"

class ForecastRepositoryImpl @Inject constructor(
    private val apiConfig: ApiConfig,
    private val forecastService: ForecastService
) : ForecastRepository {

    override fun getDailyForecast(latitude: Float, longitude: Float): Single<ForecastDto> =
        forecastService.getDailyForecast(
            latitude,
            longitude,
            UNITS,
            EXCLUDE,
            apiConfig.getApiKey()
        )
}
