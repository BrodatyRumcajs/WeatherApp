package com.weatherapp.common.model.mapper

import com.weatherapp.adapter.recyclerview.item.DailyForecastItemViewModelFactory
import com.weatherapp.api.model.ForecastDto
import com.weatherapp.common.model.Forecast

private const val NUM_DAILY_FORECASTS = 6

fun mapForecastDtoToForecast(
    dto: ForecastDto,
    city: String,
    dailyForecastItemViewModelFactory: DailyForecastItemViewModelFactory
) = with(dto) {
    Forecast(
        mapCurrentForecastDtoToCurrentForecast(currentForecast, city),
        dailyForecasts.take(NUM_DAILY_FORECASTS).map { dailyForecastDto ->
            dailyForecastItemViewModelFactory.createDailyForecastItemViewModel(
                mapDailyForecastDtoToDailyForecast(dailyForecastDto)
            )
        }
    )
}
