package com.algawas.pocketcloset.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.algawas.pocketcloset.R
import com.algawas.pocketcloset.model.weather.ApiInterface
import com.algawas.pocketcloset.model.weather.CurrentWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.open-meteo.com/"



class ChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        //#################API Fetch##################
        getWeather()


    }
    private fun getWeather(){
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<CurrentWeather>?> {
            override fun onResponse(
                call: Call<List<CurrentWeather>?>,
                response: Response<List<CurrentWeather>?>
            ) {
                val stringBuilder = StringBuilder()
                val responseBody = response.body()!! //it won't be null
                for(myData in responseBody){
                    stringBuilder.append("${myData.temperature} \n")
                }
                val textId = findViewById<TextView>(R.id.test)
                textId.text = stringBuilder
            }

            override fun onFailure(call: Call<List<CurrentWeather>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}