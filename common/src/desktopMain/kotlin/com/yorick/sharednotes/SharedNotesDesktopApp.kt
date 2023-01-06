package com.yorick.sharednotes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import com.yorick.sharednotes.ui.category.CategoriesViewModel
import com.yorick.sharednotes.ui.contact.ContactsViewModel
import com.yorick.sharednotes.ui.edit.EditViewModel
import com.yorick.sharednotes.ui.navigation.*
import com.yorick.sharednotes.ui.note.NotesViewModel
import com.yorick.sharednotes.ui.tag.TagsViewModel
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import com.yorick.sharednotes.ui.utils.SharedNotesNavigationContentPosition
import com.yorick.sharednotes.ui.utils.SharedNotesNavigationType
import kotlinx.coroutines.CoroutineScope
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun SharedNotesDesktopApp(
    windowState: WindowState,
    notesViewModel: NotesViewModel,
    contactsViewModel: ContactsViewModel,
    categoriesViewModel: CategoriesViewModel,
    tagsViewModel: TagsViewModel,
    editViewModel: EditViewModel
) {
    val scope = rememberCoroutineScope()

    var contentType: SharedNotesContentType by mutableStateOf(SharedNotesContentType.SINGLE_PANE)

    contentType = if (windowState.size.width < 800.dp) {
        SharedNotesContentType.SINGLE_PANE
    } else {
        SharedNotesContentType.DUAL_PANE
    }

    val navigator = rememberNavigator()
    val navigationActions = remember(navigator) { NavigationActions(navigator) }
    val backStackEntry by navigator.currentEntry.collectAsState(null)
    val selectedDestination = backStackEntry?.route?.route ?: SharedNotesRoute.NOTES

    val addNote = {
        navigator.navigate(EditDestination.route)
        editViewModel.onInit()
    }
//    Column {
//        Text(text = windowState.size.width.value.toString())
//        Text(text = windowState.size.height.value.toString())
//        Text(text = contentType.toString())
//    }
    SharedNotesDesktopAppContent(
        navigator = navigator,
        windowState=windowState,
        navigationType = SharedNotesNavigationType.NAVIGATION_RAIL,
        contentType = contentType,
        selectedDestination = selectedDestination,
        navigateToTopLevelDestination = navigationActions::navigateTo,
        notesViewModel = notesViewModel,
        contactsViewModel = contactsViewModel,
        categoriesViewModel = categoriesViewModel,
        tagsViewModel = tagsViewModel,
        editViewModel = editViewModel,
        addNote = addNote,
        scope = scope
    )
}

@Composable
fun SharedNotesDesktopAppContent(
    modifier: Modifier = Modifier,
    windowState: WindowState,
    navigator: Navigator,
    navigationType: SharedNotesNavigationType,
    contentType: SharedNotesContentType,
    notesViewModel: NotesViewModel,
    contactsViewModel: ContactsViewModel,
    categoriesViewModel: CategoriesViewModel,
    tagsViewModel: TagsViewModel,
    editViewModel: EditViewModel,
    selectedDestination: String = SharedNotesRoute.NOTES,
    navigationContentPosition: SharedNotesNavigationContentPosition = SharedNotesNavigationContentPosition.CENTER,
    navigateToTopLevelDestination: (SharedNotesTopLevelDestination) -> Unit,
    addNote: () -> Unit,
    scope: CoroutineScope,
) {
    Row(modifier = modifier.fillMaxSize()) {
        AnimatedVisibility(visible = navigationType == SharedNotesNavigationType.NAVIGATION_RAIL) {
            SharedNotesNavigationRail(
                selectedDestination = selectedDestination,
                navigationContentPosition = navigationContentPosition,
                navigateToTopLevelDestination = navigateToTopLevelDestination,
                onDrawerClicked = { },
                addNote = addNote
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            SharedNotesNavHost(
                navigator = navigator,
                windowState=windowState,
                contentType = contentType,
                notesViewModel = notesViewModel,
                contactsViewModel = contactsViewModel,
                categoriesViewModel = categoriesViewModel,
                tagsViewModel = tagsViewModel,
                editViewModel = editViewModel,
                scope = scope
            )
        }
    }
}