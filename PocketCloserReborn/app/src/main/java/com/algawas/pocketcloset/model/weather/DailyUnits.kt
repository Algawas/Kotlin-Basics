package com.algawas.pocketcloset.model.weather

data class DailyUnits(
    val precipitation_sum: String,
    val rain_sum: String,
    val showers_sum: String,
    val temperature_2m_max: String,
    val temperature_2m_min: String,
    val time: String,
    val weathercode: String
)