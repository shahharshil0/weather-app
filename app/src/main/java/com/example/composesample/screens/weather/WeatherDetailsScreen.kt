package com.example.composesample.screens.weather

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composesample.utils.NetworkState
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun WeatherDetailsScreen() {
    val viewModel = hiltViewModel<WeatherVM>()
    val weatherResponse = viewModel.weatherResponse.collectAsState()

    when (val weather = weatherResponse.value) {
        is NetworkState.Error -> {
            Log.d(TAG, weather.message)
        }

        is NetworkState.Loading -> {
            Log.d(TAG, "Loading")
        }

        is NetworkState.Success -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val temperature = weather.data.main?.temp ?: 0.0
                Text(text = "Weather is: $temperature")

                Spacer(modifier = Modifier.height(10.dp))

                if (temperature > 25.0) {
                    Text(text = "Too Hot Today!")
                }
            }
        }
    }
}

private const val TAG = "API"