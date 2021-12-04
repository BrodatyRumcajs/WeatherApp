package com.weatherapp.common.model

import com.weatherapp.adapter.recyclerview.item.DailyForecastItemViewModel

data class Forecast(
    val currentForecast: CurrentForecast,
    val dailyForecasts: List<DailyForecastItemViewModel>
)
