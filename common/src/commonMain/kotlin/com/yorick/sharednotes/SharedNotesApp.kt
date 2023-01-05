package com.yorick.sharednotes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yorick.sharednotes.data.local.LocalAccountsDataProvider
import com.yorick.sharednotes.data.local.LocalCategoriesDataProvider
import com.yorick.sharednotes.data.local.LocalNotesDataProvider
import com.yorick.sharednotes.ui.category.CategoriesListScreen
import com.yorick.sharednotes.ui.contact.ContactListScreen
import com.yorick.sharednotes.ui.note.NoteListScreen

@Composable
fun App() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        NoteListScreen(
            modifier = Modifier.weight(1f),
            notes = LocalNotesDataProvider.allNotes,
            navigateToDetail = { _, _ -> },
            noteLazyListState = rememberLazyListState()
        )
        ContactListScreen(
            modifier = Modifier.weight(1f),
            accounts = LocalAccountsDataProvider.allUserContactAccounts,
            navigateToDetail = { _, _ -> },
            contactLazyListState = rememberLazyListState()
        )
        CategoriesListScreen(
            modifier = Modifier.weight(1f),
            categories = LocalCategoriesDataProvider.allCategory,
            categoryLazyListState = rememberLazyListState()
        )
    }
}
