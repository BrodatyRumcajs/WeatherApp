package com.weatherapp.search.usecase

import com.weatherapp.adapter.recyclerview.item.CityItemViewModel
import com.weatherapp.api.repositry.SearchRepository
import com.weatherapp.common.model.mapper.mapCityDtoToCity
import com.weatherapp.di.qualifiers.BackgroundScheduler
import com.weatherapp.di.qualifiers.ForegroundScheduler
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    @BackgroundScheduler private val backgroundScheduler: Scheduler,
    @ForegroundScheduler private val foregroundScheduler: Scheduler,
    private val searchRepository: SearchRepository
) : (String) -> Single<List<CityItemViewModel>> {

    override fun invoke(city: String): Single<List<CityItemViewModel>> =
        searchRepository.searchCity(city)
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
            .map { cityDtos ->
                cityDtos.map { cityDto ->
                    CityItemViewModel(mapCityDtoToCity(cityDto))
                }
            }
}
