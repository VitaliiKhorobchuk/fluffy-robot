package com.sixoutoften.recepier.temp.data.repository

import android.database.sqlite.SQLiteException
import com.sixoutoften.recepier.temp.data.db.document.DocumentDao
import com.sixoutoften.recepier.temp.data.db.document.DocumentListEntity
import com.sixoutoften.recepier.temp.domain.model.Document
import com.sixoutoften.recepier.temp.domain.repository.DocumentRepository
import com.sixoutoften.recepier.util.Result
import com.sixoutoften.recepier.util.SimpleResult
import javax.inject.Inject

class DocumentRepositoryImpl @Inject constructor(
    private val documentDao: DocumentDao
) : DocumentRepository {

    override suspend fun save(document: Document): SimpleResult {
        return try {
            documentDao.insert(document.toDocumentEntity())
            Result.Success(null)
        } catch (e: SQLiteException) {
            // TODO: 22.01.2022 record crash
            Result.Error(e)
        }
    }

    override suspend fun saveAll(documents: List<Document>): SimpleResult {
        return try {
            documentDao.insertAll(
                documents.map { it.toDocumentEntity() }
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

    override suspend fun getAllForList(): List<DocumentListEntity> {
        // TODO: 22.01.2022 real impl
        return documentDao.getAllForList()
    }
}