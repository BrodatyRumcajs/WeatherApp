package com.weatherapp.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.weatherapp.datastore.model.SelectedCity
import com.weatherapp.datastore.serializer.SelectedCitySerializer
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val DATA_STORE_FILE_NAME = "selected_city_prefs.pb"

private val Context.selectedCityDataStore: DataStore<SelectedCity> by dataStore(
    fileName = DATA_STORE_FILE_NAME,
    serializer = SelectedCitySerializer
)

class SelectedCityStoreImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : SelectedCityStore {

    override val selectedCityFlow: Flow<SelectedCity> = context.selectedCityDataStore.data

    override suspend fun updateSelectedCity(name: String, latitude: Float, longitude: Float) {
        context.selectedCityDataStore.updateData { selectedCity ->
            selectedCity.toBuilder()
                .setName(name)
                .setLatitude(latitude)
                .setLongitude(longitude)
                .build()
        }
    }
}
