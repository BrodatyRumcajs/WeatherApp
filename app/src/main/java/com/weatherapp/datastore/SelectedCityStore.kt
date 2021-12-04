package com.weatherapp.datastore

import com.weatherapp.datastore.model.SelectedCity
import kotlinx.coroutines.flow.Flow

interface SelectedCityStore {

    val selectedCityFlow: Flow<SelectedCity>

    suspend fun updateSelectedCity(name: String, latitude: Float, longitude: Float)
}
