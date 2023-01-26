package com.algawas.pocketcloset.model.weather

data class HourlyUnits(
    val apparent_temperature: String,
    val precipitation: String,
    val temperature_2m: String,
    val time: String,
    val weathercode: String
)