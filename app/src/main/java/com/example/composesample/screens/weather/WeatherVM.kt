package com.example.composesample.screens.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composesample.data.models.WeatherResponse
import com.example.composesample.domain.GetWeatherUseCase
import com.example.composesample.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherVM @Inject constructor(
    private val useCase: GetWeatherUseCase
) : ViewModel() {

    //region get weather details
    init {
        useCase
            .getWeather()
            .onEach {
                _weatherResponse.emit(it)
            }.launchIn(viewModelScope)
    }

    private val _weatherResponse: MutableStateFlow<NetworkState<WeatherResponse>> =
        MutableStateFlow(NetworkState.Loading())
    val weatherResponse: StateFlow<NetworkState<WeatherResponse>> = _weatherResponse
    //endregion
}