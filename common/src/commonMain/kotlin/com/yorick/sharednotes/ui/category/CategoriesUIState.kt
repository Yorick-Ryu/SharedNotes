package com.yorick.sharednotes.ui.category

import com.yorick.sharednotes.data.model.Category
import com.yorick.sharednotes.data.model.Note

data class CategoriesUIState(
    val categories: List<Category> = emptyList(),
    val categoryNotes: List<Note> = emptyList(),
    val selectedCategory: Category? = null,
    val isDetailOnlyOpen: Boolean = false,
    val loading: Boolean = false,
    val error: String? = null
)