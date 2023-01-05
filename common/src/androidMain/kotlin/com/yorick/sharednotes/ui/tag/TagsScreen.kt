package com.yorick.sharednotes.ui.tag

import androidx.compose.runtime.Composable
import androidx.window.layout.DisplayFeature
import com.yorick.sharednotes.ui.components.UIState
import com.yorick.sharednotes.ui.note.NoteScreen
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import com.yorick.sharednotes.ui.utils.SharedNotesNavigationType

@Composable
fun TagsScreen(
    contentType: SharedNotesContentType,
    tagsUIState: UIState,
    navigationType: SharedNotesNavigationType,
    displayFeatures: List<DisplayFeature>,
    closeDetailScreen: () -> Unit,
    addNote: () -> Unit,
    onClickChip: (Long) -> Unit = {},
    navigateToDetail: (Long, SharedNotesContentType) -> Unit,
) {
    NoteScreen(
        contentType = contentType,
        notesUIState = tagsUIState,
        navigationType = navigationType,
        displayFeatures = displayFeatures,
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