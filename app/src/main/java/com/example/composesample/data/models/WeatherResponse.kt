package com.example.composesample.data.models

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("main")
    val main: WeatherMainResponse?
)