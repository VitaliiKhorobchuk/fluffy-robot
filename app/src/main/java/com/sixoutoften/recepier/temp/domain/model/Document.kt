package com.sixoutoften.recepier.temp.domain.model

import com.sixoutoften.recepier.temp.data.db.document.DocumentEntity

data class Document(
    val title: String,
    val description: String?,
    val createDate: Long,
    val expireDate: Long,
    val tags: List<String>?
) {

    fun toDocumentEntity(): DocumentEntity {
        return DocumentEntity(
            title,
            description,
            createDate,
            expireDate,
            tags
        )
    }
}
