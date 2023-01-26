package com.algawas.pocketcloset.model.weather

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
   //review weather type
   @GET("v1/forecast?latitude=24.69&longitude=46.72&hourly=temperature_2m,apparent_temperature,precipitation,weathercode&daily=weathercode,temperature_2m_max,temperature_2m_min,precipitation_sum,rain_sum,showers_sum&current_weather=true&timezone=auto&start_date=2023-01-25&end_date=2023-01-25")
   fun getData(): Call<List<CurrentWeather>>

}