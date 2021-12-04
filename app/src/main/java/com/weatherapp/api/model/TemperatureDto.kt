package com.weatherapp.api.model

import com.google.gson.annotations.SerializedName

data class TemperatureDto(
    @SerializedName("day")
    val day: Float,
    @SerializedName("night")
    val night: Float,
    @SerializedName("morn")
    val morning: Float,
    @SerializedName("eve")
    val evening: Float,
    @SerializedName("min")
    val min: Float,
    @SerializedName("max")
    val max: Float
)

