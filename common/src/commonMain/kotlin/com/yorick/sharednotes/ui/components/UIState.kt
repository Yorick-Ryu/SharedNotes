package com.yorick.sharednotes.ui.components

import com.yorick.sharednotes.data.model.Note

interface UIState {
    val notes: List<Note>
    val selectedNote: Note?
    val loading: Boolean
    val error: String?
    val isDetailOnlyOpen:Boolean
}