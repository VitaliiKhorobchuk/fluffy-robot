package com.sixoutoften.recepier.ui.home.documents

import com.sixoutoften.recepier.temp.domain.model.Document
import com.sixoutoften.recepier.ui.UiState

class DocumentListState(
    val documents: List<Document>? = listOf(),
    isLoading: Boolean = false,
    error: Error? = null
) : UiState(isLoading, error)
