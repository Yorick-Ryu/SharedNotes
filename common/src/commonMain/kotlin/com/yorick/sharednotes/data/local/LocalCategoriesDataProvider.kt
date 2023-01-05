package com.yorick.sharednotes.data.local

import com.yorick.sharednotes.data.model.Category

object LocalCategoriesDataProvider {
    val allCategory = listOf(
        Category(
            id = 0L,
            name = "Kotlin",
            sum = 3
        ),
        Category(
            id = 1L,
            name = "Android",
            sum = 1
        ),
        Category(
            id = 2L,
            name = "Java",
            sum = 1
        )
    )

    fun getCategoryById(id: Long): Category {
        return allCategory.first { it.id == id }
    }
}