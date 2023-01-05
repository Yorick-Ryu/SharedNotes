package com.yorick.sharednotes.data.local

import com.yorick.sharednotes.data.model.Tag

object LocalTagsDataProvider {
    val allTags = listOf(
        Tag(
            id = 0L,
            name = "layout",
            sum = 2
        ),
        Tag(
            id = 1L,
            name = "List",
            sum = 2
        ),
        Tag(
            id = 2L,
            name = "Set",
            sum = 2
        ),
        Tag(
            id = 3L,
            name = "Map",
            sum = 2
        ),
        Tag(
            id = 4L,
            name = "Compose",
            sum = 2
        ),
        Tag(
            id = 5L,
            name = "String",
            sum = 2
        ),
        Tag(
            id = 6L,
            name = "View",
            sum = 2
        ),
        Tag(
            id = 7L,
            name = "Jetpack",
            sum = 2
        ),
        Tag(
            id = 8L,
            name = "Sort",
            sum = 2
        ),
        Tag(
            id = 9L,
            name = "OOP",
            sum = 2
        ),
        Tag(
            id = 10L,
            name = "Icon",
            sum = 2
        ),
        Tag(
            id = 11L,
            name = "Stack",
            sum = 2
        ),
        Tag(
            id = 12L,
            name = "sql",
            sum = 2
        ),
        Tag(
            id = 13L,
            name = "DFS",
            sum = 2
        ),
        Tag(
            id = 14L,
            name = "Textview",
            sum = 2
        ),
        Tag(
            id = 15L,
            name = "Array",
            sum = 2
        ),
        Tag(
            id = 16L,
            name = "Note",
            sum = 2
        ),
    )

    fun getTagById(id: Long): Tag {
        return allTags.first { it.id == id }
    }
}