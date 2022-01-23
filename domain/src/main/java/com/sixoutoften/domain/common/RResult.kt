package com.sixoutoften.domain.common

typealias SimpleResult = Result<Unit>

sealed class Result<T>(val data: T? = null) {
    class Success<T>(data: T?) : Result<T>(data)
    class Loading<T>(data: T? = null) : Result<T>(data)
    class Error<T>(exception: Exception, data: T? = null) : Result<T>(data)
}