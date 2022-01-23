package com.sixoutoften.domain.model


data class DocumentListItem(
    val title: String,
    val createDate: Long,
    val expireDate: Long,
    val tags: List<String>?
)
