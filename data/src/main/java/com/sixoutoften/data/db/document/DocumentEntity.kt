package com.sixoutoften.data.db.document

import androidx.room.Entity
import com.sixoutoften.domain.model.Document

@Entity(tableName = "document", primaryKeys = ["title", "createDate"])
data class DocumentEntity(
    val title: String,
    val description: String?,
    val createDate: Long,
    val expireDate: Long,
    val tags: List<String>?
) {

    constructor(document: Document) : this(
        document.title,
        document.description,
        document.createDate,
        document.expireDate,
        document.tags
    )

    fun toDocument(): Document {
        return Document(
            title,
            description,
            createDate,
            expireDate,
            tags
        )
    }
}
