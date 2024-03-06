package com.example.composesample.repository

import com.example.composesample.data.models.WeatherResponse
import com.example.composesample.data.remote.ApiService
import com.example.composesample.utils.NetworkState
import com.example.composesample.utils.commonSideEffects
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun getWeather(): Flow<NetworkState<WeatherResponse>> {
        return flow<NetworkState<WeatherResponse>> {
            emit(NetworkState.Success(data = apiService.getWeatherResponse()))
        }.commonSideEffects()
    }
}