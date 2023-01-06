package com.yorick.sharednotes.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.layout.DisplayFeature
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane
import com.yorick.sharednotes.ui.contact.ContactDetailScreen
import com.yorick.sharednotes.ui.contact.ContactListScreen
import com.yorick.sharednotes.ui.contact.ContactsUIState
import com.yorick.sharednotes.ui.utils.SharedNotesContentType

@Composable
fun ContactsScreen(
    modifier: Modifier = Modifier,
    contactsUIState: ContactsUIState,
    contentType: SharedNotesContentType,
    closeDetailScreen: () -> Unit,
    displayFeatures: List<DisplayFeature>,
    navigateToDetail: (Long, SharedNotesContentType) -> Unit
) {
    LaunchedEffect(key1 = contentType) {
        if ((contentType == SharedNotesContentType.SINGLE_PANE) && !contactsUIState.isDetailOnlyOpen) {
            closeDetailScreen()
        }
    }
    val contactLazyListState = rememberLazyListState()

    if (contentType == SharedNotesContentType.DUAL_PANE) {
        TwoPane(
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
            },
            strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 16.dp),
            displayFeatures = displayFeatures
        )
    } else {
        Box(modifier = modifier.fillMaxSize()) {
            ContactsSinglePaneContent(
                modifier = Modifier.fillMaxSize(),
                contactsUIState = contactsUIState,
                contactLazyListState = contactLazyListState,
                closeDetailScreen = closeDetailScreen,
                navigateToDetail = navigateToDetail
            )
        }
    }
}

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