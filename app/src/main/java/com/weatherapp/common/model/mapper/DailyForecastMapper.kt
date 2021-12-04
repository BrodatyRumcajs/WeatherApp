package com.weatherapp.common.model.mapper

import com.weatherapp.api.model.DailyForecastDto
import com.weatherapp.common.model.DailyForecast
import com.weatherapp.common.util.toMilliseconds

fun mapDailyForecastDtoToDailyForecast(dto: DailyForecastDto) = with(dto) {
    DailyForecast(
        timestamp.toMilliseconds(),
        humidity,
        mapTemperatureDtoToTemperature(temperature),
        weathers.firstOrNull()?.icon
    )
}
