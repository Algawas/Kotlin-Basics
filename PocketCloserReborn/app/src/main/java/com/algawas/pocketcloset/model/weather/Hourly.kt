package com.algawas.pocketcloset.model.weather

data class Hourly(
    val apparent_temperature: List<Double>,
    val precipitation: List<Double>,
    val temperature_2m: List<Double>,
    val time: List<String>,
    val weathercode: List<Int>
)