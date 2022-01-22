package com.sixoutoften.recepier.temp.data.db.document

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DocumentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = DocumentEntity::class)
    suspend fun insert(document: DocumentEntity)

    // TODO: 22.01.2022 think about update strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = DocumentEntity::class)
    suspend fun insertAll(documents: List<DocumentEntity>)

    @Query("SELECT * FROM document ORDER BY expireDate")
    suspend fun getAll(): List<DocumentEntity>

    @Query("SELECT title, createDate, expireDate, tags FROM document ORDER BY expireDate")
    suspend fun getAllForList(): List<DocumentListEntity>

}