package com.sixoutoften.domain.model


data class Document(
    val title: String,
    val description: String?,
    val createDate: Long,
    val expireDate: Long,
    val tags: List<String>?
)
