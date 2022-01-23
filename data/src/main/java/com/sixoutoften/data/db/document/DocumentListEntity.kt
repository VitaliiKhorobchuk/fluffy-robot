package com.sixoutoften.data.db.document

import androidx.room.Entity
import com.sixoutoften.domain.model.DocumentListItem

@Entity(tableName = "document")
data class DocumentListEntity(
    private val title: String,
    private val createDate: Long,
    private val expireDate: Long,
    private val tags: List<String>?
) {

    fun toDocumentListItem() = DocumentListItem(
        title,
        createDate,
        expireDate,
        tags
    )
}
