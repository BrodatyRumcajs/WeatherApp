package com.weatherapp.common.util

private const val MILLISECONDS_MULTIPLIER = 1000L

fun Long.toMilliseconds(): Long = this * MILLISECONDS_MULTIPLIER
