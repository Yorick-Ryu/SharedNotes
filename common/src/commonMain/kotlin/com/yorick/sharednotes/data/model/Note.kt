package com.yorick.sharednotes.data.model

data class Note(
    val id: Long,
    val author: Account,
    val subject: String,
    val body: String,
    val category: Category,
    val tag: List<Tag> = emptyList(),
    var isStarred: Boolean = false,
    val createdAt: String
)