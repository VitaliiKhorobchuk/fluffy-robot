package com.sixoutoften.recepier.ui.home.documents

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sixoutoften.recepier.temp.analytics.AnalyticsService
import com.sixoutoften.recepier.util.RLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DocumentsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val logger: RLogger,
    private val analyticsRepository: AnalyticsService
) : ViewModel() {

    fun initTest() {
        logger.d("init")
        analyticsRepository.logEvent("test_event")
    }
}