package com.yorick.sharednotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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

class MainActivity : ComponentActivity() {

    private val notesViewModel: NotesViewModel by viewModels()
    private val contactsViewModel: ContactsViewModel by viewModels()
    private val categoriesViewModel: CategoriesViewModel by viewModels()
    private val tagsViewModel: TagsViewModel by viewModels()
    private val editViewModel: EditViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SharedNotesTheme {
                val windowSize = calculateWindowSizeClass(this)
                val displayFeatures = calculateDisplayFeatures(this)

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