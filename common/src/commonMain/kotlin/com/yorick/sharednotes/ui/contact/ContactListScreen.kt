package com.yorick.sharednotes.ui.contact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yorick.sharednotes.data.model.Account
import com.yorick.sharednotes.ui.components.SharedNotesTopBar
import com.yorick.sharednotes.ui.components.SharedNotesSearchBar
import com.yorick.sharednotes.ui.utils.SharedNotesContentType


@Composable
fun ContactListScreen(
    modifier: Modifier = Modifier,
    accounts: List<Account>,
    contactLazyListState: LazyListState,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit = { _, _ -> }
) {
    LazyColumn(modifier = modifier, state = contactLazyListState) {
        item {
            SharedNotesSearchBar(
                modifier = Modifier.fillMaxWidth(),
                searchContent = "Search Contacts"
            )
        }
        items(items = accounts, key = { it.id }) { account ->
            ContactsListItem(account = account) { accountId ->
                navigateToDetail(accountId, SharedNotesContentType.SINGLE_PANE)
            }
        }
    }
}

@Composable
fun ContactDetailScreen(
    modifier: Modifier = Modifier,
    account: Account,
    isFullScreen: Boolean = true,
    onBackPressed: () -> Unit = {}
) {
    Column(modifier = modifier.fillMaxSize()) {
        SharedNotesTopBar(
            title = account.fullName,
            isFullScreen = isFullScreen,
            onBackPressed = onBackPressed
        )
        ContactContent(account = account)
    }
}
