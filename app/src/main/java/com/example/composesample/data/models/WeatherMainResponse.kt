package com.example.composesample.data.models


import com.google.gson.annotations.SerializedName

data class WeatherMainResponse(
    @SerializedName("temp")
    val temp: Double?
)