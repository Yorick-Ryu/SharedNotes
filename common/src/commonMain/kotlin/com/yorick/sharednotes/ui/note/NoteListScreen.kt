package com.yorick.sharednotes.ui.note

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yorick.sharednotes.data.model.Note
import com.yorick.sharednotes.ui.components.SharedNotesSearchBar
import com.yorick.sharednotes.ui.components.SharedNotesTopBar
import com.yorick.sharednotes.ui.utils.SharedNotesContentType

@Composable
fun NoteListScreen(
    notes: List<Note>,
    noteLazyListState: LazyListState,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit,
    tagsGrid: @Composable () -> Unit = {},
) {
    LazyColumn(modifier = modifier, state = noteLazyListState) {
        item {
            Column {
                SharedNotesSearchBar(
                    modifier = Modifier.fillMaxWidth(),
                    searchContent = "Search Notes"
                )
                tagsGrid()
            }
        }
        items(items = notes, key = { it.id }) { note ->
            NotesListItem(note = note) { noteId ->
                navigateToDetail(noteId, SharedNotesContentType.SINGLE_PANE)
            }
        }
    }
}

@Composable
fun NoteDetailScreen(
    modifier: Modifier = Modifier,
    note: Note,
    isFullScreen: Boolean = true,
    onBackPressed: () -> Unit = {},
    addNote: () -> Unit = {},
    stateVertical: ScrollState = rememberScrollState()
) {
    Column(modifier = modifier.fillMaxSize()) {
        SharedNotesTopBar(
            title = note.subject,
            isFullScreen = isFullScreen,
            onBackPressed = onBackPressed
        ) {
//            if (!isFullScreen) {
            IconButton(onClick = addNote) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
//            } else {
//                IconButton(onClick = { }) {
//                    Icon(
//                        imageVector = Icons.Default.MoreVert,
//                        contentDescription = "More",
//                        tint = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                }
//            }
        }
        NoteContent(
            noteBody = note.body,
            stateVertical = stateVertical,
        )
    }
}