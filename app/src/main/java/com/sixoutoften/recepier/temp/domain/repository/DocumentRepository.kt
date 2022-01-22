package com.sixoutoften.recepier.temp.domain.repository

import com.sixoutoften.recepier.temp.data.db.document.DocumentListEntity
import com.sixoutoften.recepier.temp.domain.model.Document
import com.sixoutoften.recepier.util.Result
import com.sixoutoften.recepier.util.SimpleResult

interface DocumentRepository {

    suspend fun save(document: Document): SimpleResult

    suspend fun saveAll(documents: List<Document>): SimpleResult

    suspend fun getAll(): Result<List<Document>>

    suspend fun getAllForList(): List<DocumentListEntity>
}