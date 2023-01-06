package com.yorick.sharednotes.ui.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.yorick.sharednotes.ui.screen.NotesScreen
import com.yorick.sharednotes.ui.note.NotesUIState
import com.yorick.sharednotes.ui.note.NotesViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.ui.viewModel

@Composable
fun SharedNotesNavHost(
    navigator: Navigator,
) {
    val notesViewModel = viewModel {
        NotesViewModel()
    }
    val notesUIState by notesViewModel.uiState.collectAsState(null)
    NavHost(
        navigator = navigator,
        initialRoute = SharedNotesRoute.NOTES
    ) {
        scene(
            route = SharedNotesRoute.NOTES
        ) {
            NotesScreen(
                notesUIState = notesUIState ?: NotesUIState(error = "error"),
                navigateToDetail = { noteId, pane ->
                    notesViewModel.setSelectedNote(noteId, pane)
                }
            )
        }
        scene(
            route = SharedNotesRoute.CONTACTS
        ) {
            Text(text = "CATEGORIES")
        }
        scene(
            route = SharedNotesRoute.CATEGORIES
        ) {

        }
        scene(
            route = SharedNotesRoute.TAGS
        ) {

        }
    }
}