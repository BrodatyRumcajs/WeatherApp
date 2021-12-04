package com.weatherapp.adapter.recyclerview.item

import android.content.Context
import android.text.format.DateUtils
import com.weatherapp.R
import com.weatherapp.common.formatter.DAY_FORMAT
import com.weatherapp.common.formatter.UnitsFormatter
import com.weatherapp.common.model.DailyForecast
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class DailyForecastItemViewModel @AssistedInject constructor(
    private val unitsFormatter: UnitsFormatter,
    @Assisted
    private val dailyForecast: DailyForecast
) {
    val timeStamp: Long = dailyForecast.timestamp
    val humidity: String = unitsFormatter.formatHumidity(dailyForecast.humidity)
    val tempDay: String = unitsFormatter.formatTemperature(dailyForecast.temperature.day)
    val tempNight: String = unitsFormatter.formatTemperature(dailyForecast.temperature.night)
    val tempMorning: String = unitsFormatter.formatTemperature(dailyForecast.temperature.morning)
    val tempEvening: String = unitsFormatter.formatTemperature(dailyForecast.temperature.evening)
    val tempMin: String = unitsFormatter.formatTemperature(dailyForecast.temperature.min)
    val tempMax: String = unitsFormatter.formatTemperature(dailyForecast.temperature.max)
    val weatherIcon: String? = dailyForecast.icon

    fun getTime(context: Context): String = when(DateUtils.isToday(timeStamp)) {
        true -> context.getString(R.string.today)
        else -> unitsFormatter.formatTime(timeStamp, DAY_FORMAT)
    }
}
