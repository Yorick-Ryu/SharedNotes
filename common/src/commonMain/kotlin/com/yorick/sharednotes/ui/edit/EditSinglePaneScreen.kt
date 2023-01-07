package com.yorick.sharednotes.ui.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.*
import com.yorick.sharednotes.ui.components.SharedNotesTopBar
import com.yorick.sharednotes.ui.note.NoteContent

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EditSinglePaneScreen(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    onBodyValueChange: (String) -> Unit = {},
    isEditModeEnabled: Boolean = true,
    onModeChanged: () -> Unit = {},
    onSavedNote: () -> Unit = {},
    onClickedTextButton: (char: String) -> Unit = { _ -> },
    onBackPressed: () -> Unit = {},
    onClickTitle: () -> Unit = {},
) {
    Column(
        modifier = Modifier.onPreviewKeyEvent {
            when {
                (it.isCtrlPressed && it.key == Key.S && it.type == KeyEventType.KeyUp) -> {
                    onSavedNote() // Ctrl+S: Save
                    true
                }

                (it.isCtrlPressed && it.key == Key.Q && it.type == KeyEventType.KeyUp) -> {
                    onModeChanged() // Ctrl+Q: ChangeMode
                    true
                }

                (it.key == Key.Escape && it.type == KeyEventType.KeyUp) -> {
                    onBackPressed() // Esc: Quit
                    true
                }

                else -> false
            }
        }
    ) {
        SharedNotesTopBar(
            title = title,
            isFullScreen = true,
            onBackPressed = onBackPressed,
            onClickTitle = onClickTitle
        ) {
            Row {
                IconButton(onClick = onModeChanged) {
                    Icon(
                        imageVector = if (isEditModeEnabled) Icons.Default.Visibility else Icons.Default.Edit,
                        contentDescription = "Preview",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                IconButton(onClick = onSavedNote) {
                    Icon(
                        imageVector = Icons.Default.Save,
                        contentDescription = "preview",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
        if (isEditModeEnabled) {
            EditContent(
                modifier = modifier,
                text = text,
                onBodyValueChange = onBodyValueChange,
                onClickedTextButton = onClickedTextButton,
            )
        } else {
            NoteContent(noteBody = text)
        }
    }
}