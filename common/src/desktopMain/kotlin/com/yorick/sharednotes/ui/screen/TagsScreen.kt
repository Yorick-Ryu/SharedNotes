package com.yorick.sharednotes.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.WindowState
import com.yorick.sharednotes.ui.components.UIState
import com.yorick.sharednotes.ui.tag.TagsGrid
import com.yorick.sharednotes.ui.tag.TagsUIState
import com.yorick.sharednotes.ui.utils.SharedNotesContentType

@Composable
fun TagsScreen(
    modifier: Modifier = Modifier,
    windowState: WindowState,
    tagsUIState: UIState,
    closeDetailScreen: () -> Unit,
    addNote: () -> Unit,
    onClickChip: (Long) -> Unit = {},
    navigateToDetail: (Long, SharedNotesContentType) -> Unit,
) {
    NotesScreen(
        modifier = modifier,
        windowState = windowState,
        notesUIState = tagsUIState,
        addNote = addNote,
        closeDetailScreen = closeDetailScreen,
        navigateToDetail = navigateToDetail,
        tagsGrid = {
            TagsGrid(tagsUIState = tagsUIState as TagsUIState) {
                onClickChip(it)
            }
        }
    )
}