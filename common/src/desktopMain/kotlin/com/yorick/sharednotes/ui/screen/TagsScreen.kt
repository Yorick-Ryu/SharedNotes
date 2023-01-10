package com.yorick.sharednotes.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    val stateHorizontal: ScrollState = rememberScrollState()
    NotesScreen(
        modifier = modifier,
        windowState = windowState,
        notesUIState = tagsUIState,
        addNote = addNote,
        closeDetailScreen = closeDetailScreen,
        navigateToDetail = navigateToDetail,
        tagsGrid = {
            Column {
                TagsGrid(
                    tagsUIState = tagsUIState as TagsUIState,
                    onClickChip = onClickChip,
                    stateHorizontal = stateHorizontal
                )
                HorizontalScrollbar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    adapter = rememberScrollbarAdapter(stateHorizontal),
                    style = LocalScrollbarStyle.current.copy(
                        hoverColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unhoverColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                )
            }
        }
    )
}