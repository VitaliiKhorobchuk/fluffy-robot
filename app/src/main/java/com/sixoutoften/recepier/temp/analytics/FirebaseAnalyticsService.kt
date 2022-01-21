package com.sixoutoften.recepier.temp.analytics

import android.content.Context
import android.os.Bundle
import androidx.annotation.Size
import com.google.firebase.analytics.FirebaseAnalytics
import com.sixoutoften.recepier.util.RLogger
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FirebaseAnalyticsService @Inject constructor(
    private val logger: RLogger,
    @ApplicationContext context: Context
) :
    AnalyticsService {

    private val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(context)

    override fun logEvent(
        @Size(min = 1L, max = 40L) name: String,
        params: Map<String, Any>?
    ) {
        logger.d("logEvent $name")
        analytics.logEvent(name, transformMapToBundle(params))
    }

    private fun transformMapToBundle(map: Map<String, Any?>?): Bundle? {
        map?.let {
            val bundle = Bundle()

            for (entry in it.entries) {
                when (entry.value) {
                    is String -> bundle.putString(entry.key, entry.value as String)
                    is Int -> bundle.putInt(entry.key, entry.value as Int)
                    is Boolean -> bundle.putBoolean(entry.key, entry.value as Boolean)
                    null -> {
                        logger.e("Property ${entry.key} has null value in analytics params")
                    }
                    else -> throw TypeNotPresentException(
                        "Type name",
                        Throwable("FirebaseAnalyticsProvider: ${entry.value} parameter type is not supported yet.")
                    )
                }
            }
            return bundle
        }
        return null
    }
}