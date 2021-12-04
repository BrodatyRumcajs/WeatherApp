package com.weatherapp.api.model

import com.google.gson.annotations.SerializedName

data class CityDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("lat")
    val latitude: Float,
    @SerializedName("lon")
    val longitude: Float,
    @SerializedName("country")
    val country: String,
    @SerializedName("state")
    val state: String?
)
