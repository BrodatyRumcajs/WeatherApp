package com.weatherapp.api.repositry

import com.weatherapp.api.config.ApiConfig
import com.weatherapp.api.model.CityDto
import com.weatherapp.api.service.SearchService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

private const val QUERY_PARAMS = ",,"
private const val SEARCH_CITY_LIMIT = 5

class SearchRepositoryImpl @Inject constructor(
    private val apiConfig: ApiConfig,
    private val searchService: SearchService
) : SearchRepository {

    override fun searchCity(city: String): Single<List<CityDto>> =
        searchService.searchCity(
            getQuery(city),
            SEARCH_CITY_LIMIT,
            apiConfig.getApiKey()
        )

    private fun getQuery(city: String): String = "$city$QUERY_PARAMS"
}
