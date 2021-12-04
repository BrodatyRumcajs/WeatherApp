package com.weatherapp.search.args

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

val SEARCH_CITY_RESULT_KEY = SearchCityResult::class.java.name

@Parcelize
data class SearchCityResult(
    val name: String,
    val latitude: Float,
    val longitude: Float
) : Parcelable
