package com.weatherapp.api.repositry

import com.weatherapp.api.model.CityDto
import io.reactivex.rxjava3.core.Single

interface SearchRepository {

    fun searchCity(city: String): Single<List<CityDto>>
}
