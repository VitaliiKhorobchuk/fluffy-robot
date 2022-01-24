package com.sixoutoften.recepier.util

import timber.log.Timber
import javax.inject.Inject

class TimberLogger @Inject constructor(): RLogger {

    override fun d(message: String) {
        Timber.d(message)
    }

    override fun e(message: String) {
        Timber.e(message)
    }
}