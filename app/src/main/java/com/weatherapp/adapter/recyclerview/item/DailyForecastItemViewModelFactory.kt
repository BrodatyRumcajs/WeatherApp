package com.weatherapp.adapter.recyclerview.item

import com.weatherapp.common.model.DailyForecast
import dagger.assisted.AssistedFactory

@AssistedFactory
interface DailyForecastItemViewModelFactory {

    fun createDailyForecastItemViewModel(dailyForecast: DailyForecast): DailyForecastItemViewModel
}
