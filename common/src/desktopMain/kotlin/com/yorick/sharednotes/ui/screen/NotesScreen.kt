package com.yorick.sharednotes.ui.screen

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import com.yorick.sharednotes.ui.components.SharedNotesTwoPane
import com.yorick.sharednotes.ui.components.UIState
import com.yorick.sharednotes.ui.note.NoteDetailScreen
import com.yorick.sharednotes.ui.note.NoteListScreen
import com.yorick.sharednotes.ui.note.NotesSinglePaneContent
import com.yorick.sharednotes.ui.utils.SharedNotesContentType

@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    windowState: WindowState,
    notesUIState: UIState,
    addNote: () -> Unit = {},
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit,
    tagsGrid: @Composable () -> Unit = {},
) {
    val noteLazyListState = rememberLazyListState()
    if (windowState.size.width > 850.dp) {
        SharedNotesTwoPane(
            modifier = modifier,
            first = {
                NoteListScreen(
                    notes = notesUIState.notes,
                    noteLazyListState = noteLazyListState,
                    navigateToDetail = navigateToDetail,
                    tagsGrid = tagsGrid
                )
            },
            second = {
                val stateVertical = rememberScrollState()
                NoteDetailScreen(
                    note = notesUIState.selectedNote ?: notesUIState.notes.first(),
                    isFullScreen = false,
                    addNote = addNote,
                    stateVertical = stateVertical
                )
                VerticalScrollbar(
                    modifier = Modifier.align(Alignment.CenterEnd)
                        .padding(vertical = 10.dp)
                        .padding(top = 46.dp)
                        .fillMaxHeight(),
                    adapter = rememberScrollbarAdapter(stateVertical)
                )
            }
        )
    } else {
        NotesSinglePaneContent(
            modifier = modifier.fillMaxSize(),
            notesUIState = notesUIState,
            noteLazyListState = noteLazyListState,
            closeDetailScreen = closeDetailScreen,
            navigateToDetail = navigateToDetail,
            addNote = addNote,
            tagsGrid = tagsGrid
        )
    }
}