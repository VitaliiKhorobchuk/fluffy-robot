package com.sixoutoften.domain.repository

import com.sixoutoften.domain.common.RResult
import com.sixoutoften.domain.common.SimpleResult
import com.sixoutoften.domain.model.Document
import com.sixoutoften.domain.model.DocumentListItem

interface DocumentRepository {

    suspend fun save(document: Document): SimpleResult

    suspend fun saveAll(documents: List<Document>): SimpleResult

    suspend fun getAll(): RResult<List<Document>>

    suspend fun getAllForList(): RResult<List<DocumentListItem>>
}