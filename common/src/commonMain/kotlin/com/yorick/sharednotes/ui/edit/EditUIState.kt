package com.yorick.sharednotes.ui.edit

import com.yorick.sharednotes.data.model.Account
import com.yorick.sharednotes.data.model.Category
import com.yorick.sharednotes.data.model.Note
import com.yorick.sharednotes.data.model.Tag

data class EditUIState(
    val notes: List<Note> = emptyList(),
    val account: Account? = null,
    val categories: List<Category> = emptyList(),
    val tags: List<Tag> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)

enum class EditScreenMode {
    EDIT_NOTE_MODE, ADD_NOTE_MODE
}