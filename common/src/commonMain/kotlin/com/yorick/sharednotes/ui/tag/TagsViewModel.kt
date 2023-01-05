package com.yorick.sharednotes.ui.tag

import com.yorick.sharednotes.data.model.Note
import com.yorick.sharednotes.data.model.Tag
import com.yorick.sharednotes.ui.components.UIState

data class TagsUIState(
    val tags: List<Tag> = emptyList(),
    override val notes: List<Note> = emptyList(),
    override val selectedNote: Note? = null,
    override val isDetailOnlyOpen: Boolean = false,
    override val loading: Boolean = false,
    override val error: String? = null,
) : UIState