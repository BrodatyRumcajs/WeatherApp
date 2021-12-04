package com.weatherapp.common.model.mapper

import com.weatherapp.api.model.CityDto
import com.weatherapp.common.model.City

fun mapCityDtoToCity(dto: CityDto) = with(dto) {
    City(name, latitude, longitude, country, state)
}
