package com.yorick.sharednotes

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.yorick.sharednotes.data.getImageByFileName
import com.yorick.sharednotes.data.painterResource
import com.yorick.sharednotes.ui.category.CategoriesViewModel
import com.yorick.sharednotes.ui.contact.ContactsViewModel
import com.yorick.sharednotes.ui.edit.EditViewModel
import com.yorick.sharednotes.ui.note.NotesViewModel
import com.yorick.sharednotes.ui.tag.TagsViewModel
import com.yorick.sharednotes.ui.theme.SharedNotesTheme
import com.yorick.sharednotes.ui.utils.setMinSize
import moe.tlaster.precompose.PreComposeWindow
import moe.tlaster.precompose.ui.viewModel

fun main() = application {
    val windowState = rememberWindowState(
        position = WindowPosition(alignment = Alignment.Center),
        size = DpSize(1000.dp, 750.dp),
    )
    PreComposeWindow(
        onCloseRequest = ::exitApplication,
        icon = painterResource(getImageByFileName("ic_launcher")),
        state = windowState,
        title = "Shared Notes",
    ) {
        val notesViewModel = viewModel { NotesViewModel() }
        val editViewModel = viewModel { EditViewModel() }
        val contactsViewModel = viewModel { ContactsViewModel() }
        val categoriesViewModel = viewModel { CategoriesViewModel() }
        val tagsViewModel = viewModel { TagsViewModel() }
        setMinSize()
        SharedNotesTheme {
            SharedNotesDesktopApp(
                windowState = windowState,
                notesViewModel = notesViewModel,
                contactsViewModel = contactsViewModel,
                categoriesViewModel = categoriesViewModel,
                tagsViewModel = tagsViewModel,
                editViewModel = editViewModel,
            )
        }
    }
}
