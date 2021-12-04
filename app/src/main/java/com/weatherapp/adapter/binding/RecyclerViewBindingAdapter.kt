package com.weatherapp.adapter.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weatherapp.adapter.recyclerview.CitiesRecyclerViewAdapter
import com.weatherapp.adapter.recyclerview.DailyForecastsRecyclerViewAdapter
import com.weatherapp.adapter.recyclerview.item.CityItemViewModel
import com.weatherapp.adapter.recyclerview.item.DailyForecastItemViewModel

@BindingAdapter("cities")
fun setCities(recyclerView: RecyclerView, cities: List<CityItemViewModel>?) {
    cities?.let { items ->
        (recyclerView.adapter as? CitiesRecyclerViewAdapter)?.apply {
            update(items)
        }
    }
}

@BindingAdapter("dailyForecasts")
fun setDailyForecasts(recyclerView: RecyclerView, dailyForecasts: List<DailyForecastItemViewModel>?) {
    dailyForecasts?.let { items ->
        (recyclerView.adapter as? DailyForecastsRecyclerViewAdapter)?.apply {
            update(items)
        }
    }
}
