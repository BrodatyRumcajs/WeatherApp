package com.weatherapp.common.model

data class City(
    val name: String,
    val latitude: Float,
    val longitude: Float,
    val country: String,
    val state: String?
)
