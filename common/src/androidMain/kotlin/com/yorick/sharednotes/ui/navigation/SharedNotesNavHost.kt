package com.yorick.sharednotes.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.window.layout.DisplayFeature
import com.yorick.sharednotes.ui.category.CategoriesViewModel
import com.yorick.sharednotes.ui.contact.ContactsViewModel
import com.yorick.sharednotes.ui.edit.EditViewModel
import com.yorick.sharednotes.ui.note.NotesViewModel
import com.yorick.sharednotes.ui.screen.*
import com.yorick.sharednotes.ui.tag.TagsViewModel
import com.yorick.sharednotes.ui.utils.InputKeyWordsUtil
import com.yorick.sharednotes.ui.utils.SharedNotesContentType
import com.yorick.sharednotes.ui.utils.SharedNotesNavigationType
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SharedNotesNavHost(
    navController: NavHostController,
    contentType: SharedNotesContentType,
    displayFeatures: List<DisplayFeature>,
    notesViewModel: NotesViewModel,
    contactsViewModel: ContactsViewModel,
    categoriesViewModel: CategoriesViewModel,
    tagsViewModel: TagsViewModel,
    editViewModel: EditViewModel,
    navigationType: SharedNotesNavigationType,
    modifier: Modifier = Modifier,
    scope: CoroutineScope
) {
    val notesUIState by notesViewModel.uiState.collectAsStateWithLifecycle()
    val contactsUIState by contactsViewModel.uiState.collectAsStateWithLifecycle()
    val categoriesUIState by categoriesViewModel.uiState.collectAsStateWithLifecycle()
    val tagsUIState by tagsViewModel.uiState.collectAsStateWithLifecycle()
    val editUIState by editViewModel.uiState.collectAsStateWithLifecycle()
    val addNote = {
        if (notesUIState.selectedNote != null) {
            val route =
                "${EditDestination.route}?${EditDestination.noteId}=${notesUIState.selectedNote!!.id}"
            navController.navigate(route)
            editViewModel.editingNote = notesUIState.selectedNote
        } else {
            navController.navigate(EditDestination.route)
        }
        editViewModel.onInit()
    }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SharedNotesRoute.NOTES
    ) {
        composable(SharedNotesRoute.NOTES) {
            NoteScreen(
                contentType = contentType,
                notesUIState = notesUIState,
                navigationType = navigationType,
                displayFeatures = displayFeatures,
                addNote = addNote,
                closeDetailScreen = {
                    notesViewModel.closeDetailScreen()
                },
                navigateToDetail = { noteId, pane ->
                    notesViewModel.setSelectedNote(noteId, pane)
                },
            )
        }
        composable(SharedNotesRoute.CONTACTS) {
            ContactsScreen(
                contactsUIState = contactsUIState,
                contentType = contentType,
                closeDetailScreen = {
                    contactsViewModel.closeDetailScreen()
                },
                displayFeatures = displayFeatures,
                navigateToDetail = { accountId, pane ->
                    contactsViewModel.setSelectedAccount(accountId, pane)
                }
            )
        }
        composable(SharedNotesRoute.CATEGORIES) {
            CategoriesScreen(
                categoriesUIState = categoriesUIState,
                contentType = contentType,
                closeDetailScreen = { categoriesViewModel.closeDetailScreen() },
                displayFeatures = displayFeatures,
                navigateToDetail = { categoryId, pane ->
                    categoriesViewModel.setSelectedCategory(categoryId, pane)
                }
            )
        }
        composable(SharedNotesRoute.TAGS) {
            TagsScreen(
                contentType = contentType,
                tagsUIState = tagsUIState,
                navigationType = navigationType,
                displayFeatures = displayFeatures,
                addNote = addNote,
                closeDetailScreen = {
                    tagsViewModel.closeDetailScreen()
                },
                navigateToDetail = { noteId, pane ->
                    tagsViewModel.setSelectedNote(noteId, pane)
                },
            )
        }
        composable(
            route = EditDestination.routeWithArg,
            arguments = EditDestination.arguments
        ) { navBackStackEntry ->
            editViewModel.noteId =
                navBackStackEntry.arguments?.getLong(EditDestination.noteId) ?: -1
            BackHandler(enabled = true) {
                editViewModel.onBackPress()
            }

            EditScreen(
                modifier = Modifier.imePadding().systemBarsPadding(),
                contentType = contentType,
                displayFeatures = displayFeatures,
                title = editViewModel.noteSubject,
                text = editViewModel.noteBody,
                categories = editUIState.categories.map { it.name },
                tags = editUIState.tags.map { it.name },
                isEditModeEnabled = editViewModel.isEditModeEnabled,
                isOpenNoteInfoDialog = editViewModel.isNoteInfoDialogOpen,
                isOpenSaveDialog = editViewModel.isSaveDialogOpen,
                titleEditorFocus = editViewModel.titleEditorFocus,
                onBodyValueChange = { editViewModel.onBodyValueChange(it) },
                onSubjectValueChange = { editViewModel.onSubjectValueChange(it) },
                onConfirm = { editViewModel.onConfirm() },
                onConfirmClose = {
                    editViewModel.clearAll()
                    navController.popBackStack()
                },
                onDismissRequest = {
                    if (editViewModel.noteSubject == "") {
                        editViewModel.clearAll()
                        navController.popBackStack()
                    } else {
                        editViewModel.isNoteInfoDialogOpen = false
                    }
                },
                onDismissSaveRequest = { editViewModel.isSaveDialogOpen = false },
                onModeChanged = { editViewModel.modeChange() },
                onClickedTextButton = { char ->
                    InputKeyWordsUtil.keyCodeMap[char]?.let {
                        InputKeyWordsUtil.input(
                            scope = scope,
                            it
                        )
                    }
                },
                onBackPressed = { editViewModel.onBackPress() },
                onClickTitle = {
                    editViewModel.isNoteInfoDialogOpen = true
                }
            )
        }
    }
}
