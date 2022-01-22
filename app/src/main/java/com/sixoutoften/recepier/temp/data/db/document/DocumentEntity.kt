package com.sixoutoften.recepier.temp.data.db.document

import androidx.room.Entity
import com.sixoutoften.recepier.temp.domain.model.Document

@Entity(tableName = "document", primaryKeys = ["title", "createDate"])
data class DocumentEntity(
    val title: String,
    val description: String?,
    val createDate: Long,
    val expireDate: Long,
    val tags: List<String>?
) {

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
