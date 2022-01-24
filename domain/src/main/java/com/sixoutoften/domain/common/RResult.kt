package com.sixoutoften.domain.common

typealias SimpleResult = RResult<Unit>

sealed class RResult<T>(val data: T? = null) {
    class Success<T>(data: T?) : RResult<T>(data)
    class Loading<T>(data: T? = null) : RResult<T>(data)
    class Error<T>(exception: Exception, data: T? = null) : RResult<T>(data)
}