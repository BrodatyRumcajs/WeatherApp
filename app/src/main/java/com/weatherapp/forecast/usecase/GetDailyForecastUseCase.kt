package com.weatherapp.forecast.usecase

import com.weatherapp.adapter.recyclerview.item.DailyForecastItemViewModelFactory
import com.weatherapp.api.repositry.ForecastRepository
import com.weatherapp.common.model.Forecast
import com.weatherapp.common.model.mapper.mapForecastDtoToForecast
import com.weatherapp.di.qualifiers.BackgroundScheduler
import com.weatherapp.di.qualifiers.ForegroundScheduler
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetDailyForecastUseCase @Inject constructor(
    @BackgroundScheduler private val backgroundScheduler: Scheduler,
    @ForegroundScheduler private val foregroundScheduler: Scheduler,
    private val forecastRepository: ForecastRepository,
    private val dailyForecastItemViewModelFactory: DailyForecastItemViewModelFactory
) : (String, Float, Float) -> Single<Forecast> {

    override fun invoke(city: String, latitude: Float, longitude: Float): Single<Forecast> =
        forecastRepository.getDailyForecast(latitude, longitude)
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
            .map { forecastResponseDto ->
                mapForecastDtoToForecast(
                    forecastResponseDto,
                    city,
                    dailyForecastItemViewModelFactory
                )
            }
}
