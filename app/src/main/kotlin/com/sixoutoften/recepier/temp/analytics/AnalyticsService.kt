package com.sixoutoften.recepier.temp.analytics

import androidx.annotation.Size

interface AnalyticsService {

    fun logEvent(@Size(min = 1L, max = 40L) name: String, params: Map<String, Any>? = null)
}