package com.weatherapp.common.model

data class DailyForecast(
    val timestamp: Long,
    val humidity: Int,
    val temperature: Temperature,
    val icon: String?
)
