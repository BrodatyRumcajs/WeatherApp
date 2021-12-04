package com.weatherapp.common.model.mapper

import com.weatherapp.api.model.CurrentForecastDto
import com.weatherapp.common.model.CurrentForecast
import com.weatherapp.common.util.toMilliseconds

fun mapCurrentForecastDtoToCurrentForecast(dto: CurrentForecastDto, city: String) = with(dto) {
    CurrentForecast(
        city,
        timestamp.toMilliseconds(),
        sunrise.toMilliseconds(),
        sunset.toMilliseconds(),
        temperature.toInt(),
        pressure,
        weathers.firstOrNull()?.icon
    )
}
