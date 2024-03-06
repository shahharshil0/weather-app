package com.example.composesample.domain

import com.example.composesample.data.models.WeatherResponse
import com.example.composesample.repository.WeatherRepository
import com.example.composesample.utils.NetworkState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    fun getWeather(): Flow<NetworkState<WeatherResponse>> {
        return repository.getWeather()
    }
}