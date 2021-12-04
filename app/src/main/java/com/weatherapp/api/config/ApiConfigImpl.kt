package com.weatherapp.api.config

import javax.inject.Inject

private const val API_BASE_URL = "https://api.openweathermap.org/"
private const val IMAGES_BASE_URL = "https://openweathermap.org/img/wn/"

private const val API_KEY = "19b8faf86b69dfc38aa49a84ca1563ab"

class ApiConfigImpl @Inject constructor() : ApiConfig {

    override fun getApiBaseUrl(): String = API_BASE_URL

    override fun getImagesBaseUrl(): String = IMAGES_BASE_URL

    override fun getApiKey(): String = API_KEY
}
