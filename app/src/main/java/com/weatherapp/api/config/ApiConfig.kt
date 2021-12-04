package com.weatherapp.api.config

interface ApiConfig {

    fun getApiBaseUrl(): String

    fun getImagesBaseUrl(): String

    fun getApiKey(): String
}
