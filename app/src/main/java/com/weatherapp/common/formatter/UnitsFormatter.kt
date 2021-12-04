package com.weatherapp.common.formatter

import android.text.format.DateFormat
import java.util.*
import javax.inject.Inject

const val HOUR_MINUTE_FORMAT = "HH:mm"
const val DAY_FORMAT = "EEEE, d MMMM"
const val DATE_TIME_FORMAT = "EEEE, dd.MM.yyyy\nHH:mm"

private const val CELSIUS_DEGREE = "\u2103"
private const val HECTOPASCAL = "hPa"
private const val PERCENT = "%"

class UnitsFormatter @Inject constructor() {

    fun formatTemperature(temperature: Int): String = "$temperature $CELSIUS_DEGREE"

    fun formatPressure(pressure: Int): String = "$pressure $HECTOPASCAL"

    fun formatTime(timestamp: Long, format: String): String {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = timestamp
        }
        return DateFormat.format(format, calendar).toString()
    }

    fun formatHumidity(humidity: Int): String = "$humidity $PERCENT"
}
