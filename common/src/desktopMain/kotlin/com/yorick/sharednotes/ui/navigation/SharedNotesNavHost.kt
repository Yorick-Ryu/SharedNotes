package com.yorick.sharednotes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.WindowState
import com.yorick.sharednotes.ui.category.CategoriesUIState
import com.yorick.sharednotes.ui.category.CategoriesViewModel
import com.yorick.sharednotes.ui.contact.ContactsUIState
import com.yorick.sharednotes.ui.contact.ContactsViewModel
import com.yorick.sharednotes.ui.edit.EditScreen
import com.yorick.sharednotes.ui.edit.EditViewModel
import com.yorick.sharednotes.ui.note.NotesUIState
import com.yorick.sharednotes.ui.note.NotesViewModel
import com.yorick.sharednotes.ui.screen.CategoriesScreen
import com.yorick.sharednotes.ui.screen.ContactsScreen
import com.yorick.sharednotes.ui.screen.NotesScreen
import com.yorick.sharednotes.ui.screen.TagsScreen
import com.yorick.sharednotes.ui.tag.TagsUIState
import com.yorick.sharednotes.ui.tag.TagsViewModel
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import moe.tlaster.precompose.navigation.BackHandler
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun SharedNotesNavHost(
    navigator: Navigator,
    windowState: WindowState,
    contentType: SharedNotesContentType,
    notesViewModel: NotesViewModel,
    contactsViewModel: ContactsViewModel,
    categoriesViewModel: CategoriesViewModel,
    tagsViewModel: TagsViewModel,
    editViewModel: EditViewModel,
    scope: CoroutineScope
) {
    val notesUIState by notesViewModel.uiState.collectAsState(null)
    val contactsUIState by contactsViewModel.uiState.collectAsState(null)
    val categoriesUIState by categoriesViewModel.uiState.collectAsState(null)
    val tagsUIState by tagsViewModel.uiState.collectAsState(null)
    val editUIState by editViewModel.uiState.collectAsState(null)
    val addNote = {
        if (notesUIState?.selectedNote != null) {
            val route =
                "${EditDestination.route}?${EditDestination.noteId}=${notesUIState!!.selectedNote!!.id}"
            navigator.navigate(route)
            editViewModel.editingNote = notesUIState!!.selectedNote
        } else {
            navigator.navigate(EditDestination.route)
        }
        editViewModel.onInit()
    }
    NavHost(
        navigator = navigator,
        initialRoute = SharedNotesRoute.NOTES
    ) {
        scene(
            route = SharedNotesRoute.NOTES
        ) {
            NotesScreen(
                windowState = windowState,
                notesUIState = notesUIState ?: NotesUIState(error = "Error!"),
                addNote = addNote,
                navigateToDetail = { noteId, pane ->
                    notesViewModel.setSelectedNote(noteId, pane)
                },
                closeDetailScreen = {
                    notesViewModel.closeDetailScreen()
                }
            )
        }
        scene(
            route = SharedNotesRoute.CONTACTS
        ) {
            ContactsScreen(
                contactsUIState = contactsUIState ?: ContactsUIState(error = "Error!"),
                windowState = windowState,
                closeDetailScreen = {
                    contactsViewModel.closeDetailScreen()
                },
                navigateToDetail = { accountId, pane ->
                    contactsViewModel.setSelectedAccount(accountId, pane)
                }
            )
        }
        scene(
            route = SharedNotesRoute.CATEGORIES
        ) {
            CategoriesScreen(
                categoriesUIState = categoriesUIState ?: CategoriesUIState(error = "Error!"),
                windowState = windowState,
                closeDetailScreen = { categoriesViewModel.closeDetailScreen() },
                navigateToDetail = { categoryId, pane ->
                    categoriesViewModel.setSelectedCategory(categoryId, pane)
                }
            )
        }
        scene(
            route = SharedNotesRoute.TAGS
        ) {
            TagsScreen(
                windowState = windowState,
                tagsUIState = tagsUIState ?: TagsUIState(error = "Error!"),
                addNote = addNote,
                closeDetailScreen = {
                    tagsViewModel.closeDetailScreen()
                },
                navigateToDetail = { noteId, pane ->
                    tagsViewModel.setSelectedNote(noteId, pane)
                },
            )
        }
        scene(
            route = EditDestination.routeWithArg
        ) { backStackEntry ->
            editViewModel.noteId = backStackEntry.path<Long>(EditDestination.noteId) ?: -1
            BackHandler {
                editViewModel.onBackPress()
            }
            EditScreen(
                title = editViewModel.noteSubject,
                text = editViewModel.noteBody,
                categories = editUIState?.categories?.map { it.name } ?: emptyList(),
                tags = editUIState?.tags?.map { it.name } ?: emptyList(),
                isEditModeEnabled = editViewModel.isEditModeEnabled,
                isOpenNoteInfoDialog = editViewModel.isNoteInfoDialogOpen,
                isOpenSaveDialog = editViewModel.isSaveDialogOpen,
                titleEditorFocus = editViewModel.titleEditorFocus,
                onBodyValueChange = { editViewModel.onBodyValueChange(it) },
                onSubjectValueChange = { editViewModel.onSubjectValueChange(it) },
                onConfirm = { editViewModel.onConfirm() },
                onConfirmClose = {
                    editViewModel.isSaveDialogOpen = false
                    editViewModel.editingNote = null
                    editViewModel.noteSubject = ""
                    editViewModel.noteBody = ""
                    navigator.popBackStack()
                },
                onDismissRequest = { editViewModel.isNoteInfoDialogOpen = false },
                onDismissSaveRequest = { editViewModel.isSaveDialogOpen = false },
                onModeChanged = { editViewModel.modeChange() },
                onClickedTextButton = { char ->
                    //TODO input char
                },
                onBackPressed = { editViewModel.onBackPress() },
                onClickTitle = {
                    editViewModel.isNoteInfoDialogOpen = true
                }
            )
        }
    }
}
