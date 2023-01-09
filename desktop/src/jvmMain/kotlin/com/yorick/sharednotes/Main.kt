package com.yorick.sharednotes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.yorick.sharednotes.data.getImageByFileName
import com.yorick.sharednotes.data.painterResource
import com.yorick.sharednotes.ui.category.CategoriesViewModel
import com.yorick.sharednotes.ui.components.SharedNotesMenuBar
import com.yorick.sharednotes.ui.contact.ContactsViewModel
import com.yorick.sharednotes.ui.edit.EditViewModel
import com.yorick.sharednotes.ui.note.NotesViewModel
import com.yorick.sharednotes.ui.tag.TagsViewModel
import com.yorick.sharednotes.ui.theme.SharedNotesTheme
import com.yorick.sharednotes.ui.utils.setMinSize
import moe.tlaster.precompose.PreComposeWindow
import moe.tlaster.precompose.ui.viewModel

@OptIn(ExperimentalMaterial3Api::class)
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
        undecorated = true,
        transparent = true
    ) {
        val notesViewModel = viewModel { NotesViewModel() }
        val editViewModel = viewModel { EditViewModel() }
        val contactsViewModel = viewModel { ContactsViewModel() }
        val categoriesViewModel = viewModel { CategoriesViewModel() }
        val tagsViewModel = viewModel { TagsViewModel() }
        var darkTheme: Boolean by remember { mutableStateOf(false) }
        setMinSize()
        SharedNotesTheme(
            darkTheme = darkTheme
        ) {
            Card(
                shape = MaterialTheme.shapes.medium,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SharedNotesMenuBar(
                        modifier = Modifier,
                        windowState = windowState,
                        isDarkTheme = darkTheme,
                        switchTheme = { darkTheme = !darkTheme },
                        onCloseRequest = ::exitApplication
                    )
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
    }
}
