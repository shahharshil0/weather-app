package com.example.composesample.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart


fun <T> Flow<NetworkState<T>>.commonSideEffects(): Flow<NetworkState<T>> {
    return onStart {
        emit(NetworkState.Loading())
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(NetworkState.Error(throwable = it, message = it.message.orEmpty()))
        }
}