package com.weatherapp.api.model

import com.google.gson.annotations.SerializedName

data class CurrentForecastDto(
    @SerializedName("dt")
    val timestamp: Long,
    @SerializedName("sunrise")
    val sunrise: Long,
    @SerializedName("sunset")
    val sunset: Long,
    @SerializedName("temp")
    val temperature: Float,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("weather")
    val weathers: List<WeatherDto>
)
