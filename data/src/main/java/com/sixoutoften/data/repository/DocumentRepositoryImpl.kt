package com.sixoutoften.data.repository

import android.database.sqlite.SQLiteException
import com.sixoutoften.data.db.document.DocumentDao
import com.sixoutoften.data.db.document.DocumentEntity
import com.sixoutoften.domain.common.Result
import com.sixoutoften.domain.common.SimpleResult
import com.sixoutoften.domain.model.Document
import com.sixoutoften.domain.model.DocumentListItem
import com.sixoutoften.domain.repository.DocumentRepository
import javax.inject.Inject

class DocumentRepositoryImpl @Inject constructor(
    private val documentDao: DocumentDao
) : DocumentRepository {

    override suspend fun save(document: Document): SimpleResult {
        return try {
            documentDao.insert(DocumentEntity(document))
            Result.Success(null)
        } catch (e: SQLiteException) {
            // TODO: 22.01.2022 record crash
            Result.Error(e)
        }
    }

    override suspend fun saveAll(documents: List<Document>): SimpleResult {
        return try {
            documentDao.insertAll(
                documents.map { DocumentEntity(it) }
            )
            Result.Success(null)
        } catch (e: SQLiteException) {
            // TODO: 22.01.2022 record crash
            Result.Error(e)
        }
    }

    override suspend fun getAll(): Result<List<Document>> {
        return try {
            Result.Success(documentDao.getAll().map { it.toDocument() })
        } catch (e: SQLiteException) {
            // TODO: 22.01.2022 record crash
            Result.Error(e)
        }
    }

    override suspend fun getAllForList(): Result<List<DocumentListItem>> {
        // TODO: 22.01.2022 real impl
        return try {
            Result.Success(documentDao.getAllForList().map { it.toDocumentListItem() })
        } catch (e: SQLiteException) {
            // TODO: 22.01.2022 record crash
            Result.Error(e)
        }
    }
}