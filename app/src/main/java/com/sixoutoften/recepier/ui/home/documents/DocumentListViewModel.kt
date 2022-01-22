package com.sixoutoften.recepier.ui.home.documents

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sixoutoften.recepier.temp.analytics.AnalyticsService
import com.sixoutoften.recepier.temp.domain.repository.DocumentRepository
import com.sixoutoften.recepier.temp.domain.use_case.GetAllDocumentsUseCase
import com.sixoutoften.recepier.ui.UiState
import com.sixoutoften.recepier.util.RLogger
import com.sixoutoften.recepier.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DocumentListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val logger: RLogger,
    private val analyticsRepository: AnalyticsService,
    private val documentRepository: DocumentRepository,
    private val getAllDocumentsUseCase: GetAllDocumentsUseCase
) : ViewModel() {

    private val _stateFlow = MutableStateFlow(DocumentListState())
    val stateFlow = _stateFlow.asStateFlow()

    fun initTest() {
        logger.d("init")
        analyticsRepository.logEvent("test_event")

        testDb()
    }

    private fun testDb() {
        viewModelScope.launch {
            val allForList = documentRepository.getAllForList()

            logger.d("all for list $allForList")
        }
        getAllDocumentsUseCase().onEach {
            val res = when (it) {
                is Result.Success -> {
                    it.data
                    _stateFlow.value = DocumentListState(it.data)
                    "success ${it.data}"
                }
                is Result.Loading -> {
                    _stateFlow.value = DocumentListState(isLoading = true)
                    "loading"
                }
                is Result.Error -> {
                    _stateFlow.value = DocumentListState(error = UiState.Error.GeneralError)
                    "error"
                }
            }
            logger.d("get all $res")
        }.launchIn(viewModelScope)
    }
}