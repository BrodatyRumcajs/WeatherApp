package com.weatherapp.api.model

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("icon")
    val icon: String
)
