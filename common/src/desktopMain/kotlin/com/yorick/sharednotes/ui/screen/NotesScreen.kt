package com.yorick.sharednotes.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import com.yorick.sharednotes.ui.components.SharedNotesTwoPane
import com.yorick.sharednotes.ui.note.NoteDetailScreen
import com.yorick.sharednotes.ui.note.NoteListScreen
import com.yorick.sharednotes.ui.note.NotesSinglePaneContent
import com.yorick.sharednotes.ui.note.NotesUIState
import com.yorick.sharednotes.ui.utils.SharedNotesContentType

@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    windowState: WindowState,
    notesUIState: NotesUIState,
    contentType: SharedNotesContentType,
    addNote: () -> Unit = {},
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit,
    tagsGrid: @Composable () -> Unit = {},
) {
    val noteLazyListState = rememberLazyListState()
    if (windowState.size.width > 850.dp) {
        SharedNotesTwoPane(
            first = {
                NoteListScreen(
                    notes = notesUIState.notes,
                    noteLazyListState = noteLazyListState,
                    navigateToDetail = navigateToDetail,
                    tagsGrid = tagsGrid
                )
            },
            second = {
                NoteDetailScreen(
                    note = notesUIState.selectedNote ?: notesUIState.notes.first(),
                    isFullScreen = false,
                    addNote = addNote
                )
            }
        )
    } else {
        NotesSinglePaneContent(
            notesUIState = notesUIState,
            noteLazyListState = noteLazyListState,
            modifier = Modifier.fillMaxSize(),
            closeDetailScreen = closeDetailScreen,
            navigateToDetail = navigateToDetail,
            addNote = addNote,
            tagsGrid = tagsGrid
        )
    }
}