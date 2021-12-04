package com.weatherapp.datastore.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.weatherapp.datastore.model.SelectedCity
import java.io.InputStream
import java.io.OutputStream

object SelectedCitySerializer : Serializer<SelectedCity> {

    override val defaultValue: SelectedCity = SelectedCity.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): SelectedCity {
        try {
            return SelectedCity.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: SelectedCity, output: OutputStream) {
        t.writeTo(output)
    }
}
