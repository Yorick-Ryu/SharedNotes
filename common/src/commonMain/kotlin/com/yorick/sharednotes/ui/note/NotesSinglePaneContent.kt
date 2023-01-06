package com.yorick.sharednotes.ui.note

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yorick.sharednotes.ui.components.UIState
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import moe.tlaster.precompose.navigation.BackHandler

@Composable
fun NotesSinglePaneContent(
    modifier: Modifier = Modifier,
    notesUIState: UIState,
    noteLazyListState: LazyListState,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit,
    addNote: () -> Unit,
    tagsGrid: @Composable () -> Unit = {},
) {
    Crossfade(
        targetState = notesUIState.selectedNote != null && notesUIState.isDetailOnlyOpen
    ) { screen ->
        when (screen) {
            true -> {
                BackHandler {
                    closeDetailScreen()
                }
                notesUIState.selectedNote?.let {
                    NoteDetailScreen(
                        note = it,
                        addNote = addNote,
                        onBackPressed = { closeDetailScreen() }
                    )
                }
            }
            false -> {
                NoteListScreen(
                    notes = notesUIState.notes,
                    noteLazyListState = noteLazyListState,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                    tagsGrid = tagsGrid,
                )
            }
        }
    }
}