package com.weatherapp.forecast.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherapp.adapter.recyclerview.item.DailyForecastItemViewModel
import com.weatherapp.common.formatter.DATE_TIME_FORMAT
import com.weatherapp.common.formatter.HOUR_MINUTE_FORMAT
import com.weatherapp.common.formatter.UnitsFormatter
import com.weatherapp.common.model.Forecast
import com.weatherapp.datastore.SelectedCityStore
import com.weatherapp.datastore.model.SelectedCity
import com.weatherapp.forecast.usecase.GetDailyForecastUseCase
import com.weatherapp.search.args.SearchCityResult
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastListViewModel @Inject constructor(
    private val selectedCityStore: SelectedCityStore,
    private val getDailyForecastUseCase: GetDailyForecastUseCase,
    private val unitsFormatter: UnitsFormatter
) : ViewModel() {

    val cityName: LiveData<String>
        get() = _cityName
    val temperature: LiveData<String>
        get() = _temperature
    val pressure: LiveData<String>
        get() = _pressure
    val sunrise: LiveData<String>
        get() = _sunrise
    val sunset: LiveData<String>
        get() = _sunset
    val lastUpdate: LiveData<String>
        get() = _lastUpdate
    val weatherIcon: LiveData<String?>
        get() = _weatherIcon
    val dailyForecasts: LiveData<List<DailyForecastItemViewModel>>
        get() = _dailyForecasts
    val refreshing: LiveData<Boolean>
        get() = _refreshing
    val forecastVisible: LiveData<Boolean>
        get() = _forecastVisible
    val noCityWarningVisible: LiveData<Boolean>
        get() = _noCityWarningVisible

    private val _cityName = MutableLiveData("")
    private val _temperature = MutableLiveData("")
    private val _pressure = MutableLiveData("")
    private val _sunrise = MutableLiveData("")
    private val _sunset = MutableLiveData("")
    private val _lastUpdate = MutableLiveData("")
    private val _weatherIcon = MutableLiveData<String?>(null)
    private val _dailyForecasts = MutableLiveData<List<DailyForecastItemViewModel>>(listOf())
    private val _refreshing = MutableLiveData(false)
    private val _forecastVisible = MutableLiveData(false)
    private val _noCityWarningVisible = MutableLiveData(false)
    private var selectedCity: SelectedCity? = null
    private var getDailyForecastDisposable: Disposable? = null

    init {
        viewModelScope.launch {
            selectedCityStore.selectedCityFlow.collect { selectedCity ->
                this@ForecastListViewModel.selectedCity = selectedCity
                getForecast()
            }
        }
    }

    fun selectCity(searchCityResult: SearchCityResult) {
        viewModelScope.launch {
            with(searchCityResult) {
                selectedCityStore.updateSelectedCity(name, latitude, longitude)
            }
        }
    }

    fun getForecast() {
        getDailyForecastDisposable?.dispose()
        _refreshing.value = false
        selectedCity?.run {
            if (name.isNotBlank()) {
                _noCityWarningVisible.value = false
                _refreshing.value = true
                getDailyForecastDisposable =
                    getDailyForecastUseCase.invoke(name, latitude, longitude)
                        .subscribe({ forecast ->
                            setForecastData(forecast)
                            _refreshing.value = false
                        }, {
                            _refreshing.value = false
                        })
            } else {
                setForecastVisibile(false)
            }
        } ?: run {
            setForecastVisibile(false)
        }
    }

    private fun setForecastData(forecast: Forecast) {
        _forecastVisible.value = true
        with(forecast.currentForecast) {
            _cityName.value = city
            _temperature.value = unitsFormatter.formatTemperature(temperature)
            _pressure.value = unitsFormatter.formatPressure(pressure)
            _lastUpdate.value = unitsFormatter.formatTime(timestamp, DATE_TIME_FORMAT)
            _sunrise.value = unitsFormatter.formatTime(sunrise, HOUR_MINUTE_FORMAT)
            _sunset.value = unitsFormatter.formatTime(sunset, HOUR_MINUTE_FORMAT)
            _weatherIcon.value = icon
        }
        _dailyForecasts.value = forecast.dailyForecasts
    }

    private fun setForecastVisibile(visible: Boolean) {
        _forecastVisible.value = visible
        _noCityWarningVisible.value = !visible
    }

    override fun onCleared() {
        super.onCleared()
        getDailyForecastDisposable?.dispose()
    }
}
