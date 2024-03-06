package com.example.composesample.data.remote

import com.example.composesample.data.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(WEATHER_ENDPOINT)
    suspend fun getWeatherResponse(
        @Query("appid") appId: String = "912c25fe5a896d110435f8823adacf1a"
    ) : WeatherResponse

    companion object {
        private const val WEATHER_ENDPOINT = "weather?lat=0&lon=0&units=metric"
    }
}