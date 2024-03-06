package com.example.composesample.utils

sealed class NetworkState<T> {
    data class Success<T>(val data: T) : NetworkState<T>()
    data class Error<T>(val throwable: Throwable, val message: String) : NetworkState<T>()
    data class Loading<T>(val data: T? = null) : NetworkState<T>()
}