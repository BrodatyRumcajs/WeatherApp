package com.weatherapp.api.service

import com.weatherapp.api.model.CityDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("geo/1.0/direct")
    fun searchCity(
        @Query("q") query: String,
        @Query("limit") limit: Int,
        @Query("appid") apiKey: String
    ): Single<List<CityDto>>
}
