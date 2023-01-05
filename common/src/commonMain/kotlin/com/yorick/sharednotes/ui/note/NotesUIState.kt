package com.yorick.sharednotes.ui.note

import com.yorick.sharednotes.data.model.Note
import com.yorick.sharednotes.ui.components.UIState

data class NotesUIState(
    override val notes: List<Note> = emptyList(),
    override val selectedNote: Note? = null,
    override val isDetailOnlyOpen: Boolean = false,
    val isEditModeEnabled: Boolean = false,
    override val loading: Boolean = false,
    override val error: String? = null
) : UIState