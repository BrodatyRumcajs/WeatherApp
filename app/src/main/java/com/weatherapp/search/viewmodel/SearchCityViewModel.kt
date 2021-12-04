package com.weatherapp.search.viewmodel

import androidx.lifecycle.*
import com.weatherapp.adapter.recyclerview.item.CityItemViewModel
import com.weatherapp.search.usecase.SearchCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class SearchCityViewModel @Inject constructor(
    private val searchCityUseCase: SearchCityUseCase
) : ViewModel() {

    val cityName = MutableLiveData<String>()
    val cities: LiveData<List<CityItemViewModel>>
        get() = _cities
    val refreshing: LiveData<Boolean>
        get() = _refreshing

    private val _cities = MutableLiveData<List<CityItemViewModel>>(listOf())
    private val _refreshing = MutableLiveData(false)
    private var searchCityDisposable: Disposable? = null
    private val cityNameObserver = Observer<String> {
        searchCity()
    }

    init {
        cityName.distinctUntilChanged().observeForever(cityNameObserver)
    }

    fun searchCity() {
        searchCityDisposable?.dispose()
        _refreshing.value = false
        cityName.value?.let { city ->
            _refreshing.value = true
            searchCityDisposable = searchCityUseCase.invoke(city).subscribe({ cities ->
                _cities.value = cities
                _refreshing.value = false
            }, {
                _refreshing.value = false
            })
        }
    }

    fun clearResults() {
        _cities.value = listOf()
    }

    override fun onCleared() {
        super.onCleared()
        cityName.removeObserver(cityNameObserver)
        searchCityDisposable?.dispose()
    }
}
