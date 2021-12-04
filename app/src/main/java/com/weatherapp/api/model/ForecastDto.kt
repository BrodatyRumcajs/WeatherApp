package com.weatherapp.api.model

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("current")
    val currentForecast: CurrentForecastDto,
    @SerializedName("daily")
    val dailyForecasts: List<DailyForecastDto>
)
