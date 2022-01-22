package com.sixoutoften.recepier.ui

open class UiState(
    open val isLoading: Boolean = false,
    val error: Error? = null
) {

    sealed class Error {
         object NetworkError : Error()
         object GeneralError : Error()
    }
}
