package com.weatherapp.adapter.recyclerview.item

import android.view.View
import com.weatherapp.common.model.City

class CityItemViewModel(val city: City) {

    val stateVisible = if (city.state != null) View.VISIBLE else View.GONE
    var clickAction: ((View, City) -> Unit)? = null

    fun onClick(view: View) {
        clickAction?.invoke(view, city)
    }
}
