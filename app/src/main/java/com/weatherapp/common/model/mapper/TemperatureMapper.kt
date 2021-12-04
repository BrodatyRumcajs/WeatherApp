package com.weatherapp.common.model.mapper

import com.weatherapp.api.model.TemperatureDto
import com.weatherapp.common.model.Temperature

fun mapTemperatureDtoToTemperature(dto: TemperatureDto) = with(dto) {
    Temperature(
        day.toInt(),
        night.toInt(),
        morning.toInt(),
        evening.toInt(),
        min.toInt(),
        max.toInt()
    )
}

