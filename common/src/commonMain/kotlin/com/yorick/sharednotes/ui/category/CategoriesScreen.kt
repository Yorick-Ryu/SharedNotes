package com.yorick.sharednotes.ui.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yorick.sharednotes.data.model.Category
import com.yorick.sharednotes.data.model.Note
import com.yorick.sharednotes.ui.components.SharedNotesAppBars
import com.yorick.sharednotes.ui.components.SharedNotesListItem
import com.yorick.sharednotes.ui.components.SharedNotesSearchBar
import com.yorick.sharednotes.ui.note.NotesListItem
import com.yorick.sharednotes.ui.utils.SharedNotesContentType


@Composable
fun CategoriesListScreen(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    categoryLazyListState: LazyListState,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit = { _, _ -> }
) {
    LazyColumn(modifier = modifier, state = categoryLazyListState) {
        item {
            SharedNotesSearchBar(
                modifier = Modifier.fillMaxWidth(),
                searchContent = "Search Categories"
            )
        }
        items(items = categories, key = { it.id }) { category ->
            SharedNotesListItem(category = category) { categoryId ->
                navigateToDetail(categoryId, SharedNotesContentType.SINGLE_PANE)
            }
        }
    }
}

@Composable
fun CategoryNotesScreen(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    isFullScreen: Boolean = true,
    noteLazyListState: LazyListState,
    onBackPressed: () -> Unit = {},
    navigateToDetail: (Long, SharedNotesContentType) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        SharedNotesAppBars(
            title = notes.first().category.name,
            isFullScreen = isFullScreen,
            onBackPressed = onBackPressed
        )
        LazyColumn(modifier = modifier, state = noteLazyListState) {
            items(items = notes, key = { it.id }) { note ->
                NotesListItem(note = note) { noteId ->
                    navigateToDetail(noteId, SharedNotesContentType.SINGLE_PANE)
                }
            }
        }
    }
}

