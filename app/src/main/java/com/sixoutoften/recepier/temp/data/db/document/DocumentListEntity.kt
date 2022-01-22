package com.sixoutoften.recepier.temp.data.db.document

import androidx.room.Entity

@Entity(tableName = "document")
data class DocumentListEntity(
    private val title: String,
    private val createDate: Long,
    private val expireDate: Long,
    private val tags: List<String>?
)
