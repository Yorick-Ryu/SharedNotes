package com.yorick.sharednotes.ui.contact

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import moe.tlaster.precompose.navigation.BackHandler

@Composable
fun ContactsSinglePaneContent(
    modifier: Modifier = Modifier,
    contactsUIState: ContactsUIState,
    contactLazyListState: LazyListState,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit
) {
    Crossfade(
        targetState = contactsUIState.selectedAccount != null && contactsUIState.isDetailOnlyOpen
    ) { screen ->
        when (screen) {
            true -> {
                BackHandler {
                    closeDetailScreen()
                }
                contactsUIState.selectedAccount?.let {
                    ContactDetailScreen(account = it) {
                        closeDetailScreen()
                    }
                }
            }
            false -> {
                ContactListScreen(
                    accounts = contactsUIState.accounts,
                    contactLazyListState = contactLazyListState,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}