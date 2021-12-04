package com.weatherapp.common.model

data class CurrentForecast(
    val city: String,
    val timestamp: Long,
    val sunrise: Long,
    val sunset: Long,
    val temperature: Int,
    val pressure: Int,
    val icon: String?
)
