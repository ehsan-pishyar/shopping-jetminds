package com.example.domain.utils

sealed class ServiceResult<T>(val data: T? = null, val error: String? = null) {
    class Loading<T>(isLoading: Boolean = true): ServiceResult<T>()
    class Success<T>(data: T? = null): ServiceResult<T>(data = data)
    class Error<T>(data: T? = null, error: String? = null): ServiceResult<T>(data = data, error = error)
}
