package com.yorick.sharednotes

import android.os.Bundle
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.google.accompanist.adaptive.calculateDisplayFeatures
import com.yorick.sharednotes.ui.SharedNotesApp
import com.yorick.sharednotes.ui.category.CategoriesViewModel
import com.yorick.sharednotes.ui.contact.ContactsViewModel
import com.yorick.sharednotes.ui.edit.EditViewModel
import com.yorick.sharednotes.ui.note.NotesViewModel
import com.yorick.sharednotes.ui.tag.TagsViewModel
import com.yorick.sharednotes.ui.theme.SharedNotesTheme
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import moe.tlaster.precompose.lifecycle.setContent
import moe.tlaster.precompose.ui.viewModel

class MainActivity : PreComposeActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SharedNotesTheme {
                val windowSize = calculateWindowSizeClass(this)
                val displayFeatures = calculateDisplayFeatures(this)

                val notesViewModel = viewModel { NotesViewModel() }
                val editViewModel = viewModel { EditViewModel() }
                val contactsViewModel = viewModel { ContactsViewModel() }
                val categoriesViewModel = viewModel { CategoriesViewModel() }
                val tagsViewModel = viewModel { TagsViewModel() }

                SharedNotesApp(
                    windowSize = windowSize,
                    displayFeatures = displayFeatures,
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