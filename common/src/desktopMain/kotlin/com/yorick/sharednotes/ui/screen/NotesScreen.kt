package com.yorick.sharednotes.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yorick.sharednotes.ui.note.NoteDetailScreen
import com.yorick.sharednotes.ui.note.NoteListScreen
import com.yorick.sharednotes.ui.note.NotesUIState
import com.yorick.sharednotes.ui.utils.SharedNotesContentType

@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    notesUIState: NotesUIState,
    addNote: () -> Unit = {},
    navigateToDetail: (Long, SharedNotesContentType) -> Unit,
    tagsGrid: @Composable () -> Unit = {},
) {
    val noteLazyListState = rememberLazyListState()
    Row(
        modifier = modifier.fillMaxSize()
    )
    {
        NoteListScreen(
            modifier = modifier.weight(1f),
            notes = notesUIState.notes,
            noteLazyListState = noteLazyListState,
            navigateToDetail = navigateToDetail,
            tagsGrid = tagsGrid
        )
        NoteDetailScreen(
            modifier = modifier.weight(2f),
            note = notesUIState.selectedNote ?: notesUIState.notes.first(),
            isFullScreen = false,
            addNote = addNote
        )
    }
}