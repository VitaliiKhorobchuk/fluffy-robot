package com.sixoutoften.recepier.ui.home.documents

import com.sixoutoften.domain.model.Document
import com.sixoutoften.recepier.ui.UiState

class DocumentListState(
    val documents: List<Document>? = listOf(),
    isLoading: Boolean = false,
    error: Error? = null
) : UiState(isLoading, error) {

    override fun toString(): String {
        return "DocumentListState { " +
                "\n documents: $documents" +
                "\n" + super.toString() +
                "\n }"
    }
}
