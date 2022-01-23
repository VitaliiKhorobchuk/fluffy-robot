package com.sixoutoften.domain.repository

import com.sixoutoften.domain.common.Result
import com.sixoutoften.domain.common.SimpleResult
import com.sixoutoften.domain.model.Document
import com.sixoutoften.domain.model.DocumentListItem

interface DocumentRepository {

    suspend fun save(document: Document): SimpleResult

    suspend fun saveAll(documents: List<Document>): SimpleResult

    suspend fun getAll(): Result<List<Document>>

    suspend fun getAllForList(): Result<List<DocumentListItem>>
}