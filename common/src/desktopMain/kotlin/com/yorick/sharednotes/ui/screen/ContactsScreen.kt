package com.yorick.sharednotes.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import com.yorick.sharednotes.ui.components.SharedNotesTwoPane
import com.yorick.sharednotes.ui.contact.ContactDetailScreen
import com.yorick.sharednotes.ui.contact.ContactListScreen
import com.yorick.sharednotes.ui.contact.ContactsSinglePaneContent
import com.yorick.sharednotes.ui.contact.ContactsUIState
import com.yorick.sharednotes.ui.utils.SharedNotesContentType

@Composable
fun ContactsScreen(
    modifier: Modifier = Modifier,
    contactsUIState: ContactsUIState,
    windowState: WindowState,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit
) {
    val contactLazyListState = rememberLazyListState()
    val isTwoPane: Boolean = windowState.size.width > 850.dp

    AnimatedVisibility(
        visible = isTwoPane,
        enter = expandHorizontally(initialWidth = { it * 5 / 13 }),
        exit = shrinkHorizontally(targetWidth = { it * 5 / 13 }) + fadeOut()
    ) {
        SharedNotesTwoPane(
            modifier = modifier,
            first = {
                ContactListScreen(
                    accounts = contactsUIState.accounts,
                    contactLazyListState = contactLazyListState,
                    navigateToDetail = navigateToDetail
                )
            },
            second = {
                ContactDetailScreen(
                    account = contactsUIState.selectedAccount ?: contactsUIState.accounts.first(),
                    isFullScreen = false
                )
            }
        )
    }
    AnimatedVisibility(
        visible = !isTwoPane,
        enter = expandHorizontally(initialWidth = { it * 5 / 13 }),
        exit = shrinkHorizontally(targetWidth = { it * 5 / 13 })
    ) {
        ContactsSinglePaneContent(
            modifier = modifier.fillMaxSize(),
            contactsUIState = contactsUIState,
            contactLazyListState = contactLazyListState,
            closeDetailScreen = closeDetailScreen,
            navigateToDetail = navigateToDetail
        )
    }
}