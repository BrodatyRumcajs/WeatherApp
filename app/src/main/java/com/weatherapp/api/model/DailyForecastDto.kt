package com.weatherapp.api.model

import com.google.gson.annotations.SerializedName

data class DailyForecastDto(
    @SerializedName("dt")
    val timestamp: Long,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("temp")
    val temperature: TemperatureDto,
    @SerializedName("weather")
    val weathers: List<WeatherDto>
)
