package com.yorick.sharednotes.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.dp
import androidx.window.layout.DisplayFeature
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane
import com.yorick.sharednotes.ui.components.NewNoteAlertDialog
import com.yorick.sharednotes.ui.components.SaveNoteAlertDialog
import com.yorick.sharednotes.ui.components.SharedNotesTopBar
import com.yorick.sharednotes.ui.edit.EditContent
import com.yorick.sharednotes.ui.edit.EditSinglePaneScreen
import com.yorick.sharednotes.ui.note.NoteContent
import com.yorick.sharednotes.ui.utils.SharedNotesContentType

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EditScreen(
    modifier: Modifier = Modifier,
    contentType: SharedNotesContentType,
    displayFeatures: List<DisplayFeature>,
    title: String,
    text: String,
    categories: List<String> = emptyList(),
    tags: List<String> = emptyList(),
    onBodyValueChange: (String) -> Unit = {},
    onSubjectValueChange: (String) -> Unit = {},
    isEditModeEnabled: Boolean = true,
    isOpenNoteInfoDialog: Boolean = false,
    isOpenSaveDialog: Boolean = false,
    titleEditorFocus: FocusRequester = remember { FocusRequester() },
    onModeChanged: () -> Unit = {},
    onSavedNote: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
    onDismissSaveRequest: () -> Unit = {},
    onConfirm: () -> Unit = {},
    onConfirmClose: () -> Unit = {},
    onClickedTextButton: (char: String) -> Unit = { _ -> },
    onBackPressed: () -> Unit = {},
    onClickTitle: () -> Unit = {},
) {
    if (isOpenNoteInfoDialog) {
        NewNoteAlertDialog(
            modifier = Modifier,
            onDismissRequest = onDismissRequest,
            onConfirm = onConfirm,
            title = title,
            onSubjectValueChange = onSubjectValueChange,
            titleEditorFocus = titleEditorFocus,
            categories = categories,
            tags = tags
        )
    }
    if (isOpenSaveDialog) {
        SaveNoteAlertDialog(
            modifier = Modifier,
            onDismissRequest = onDismissSaveRequest,
            onConfirm = onConfirmClose,
        )
    }
    if (contentType == SharedNotesContentType.DUAL_PANE) {
        Column(
            modifier = modifier.fillMaxSize().onPreviewKeyEvent {
                when {
                    (it.isCtrlPressed && it.key == Key.S && it.type == KeyEventType.KeyUp) -> {
                        onSavedNote() // Ctrl+S: Save
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
                IconButton(onClick = onSavedNote) {
                    Icon(
                        imageVector = Icons.Default.Save,
                        contentDescription = "preview",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            TwoPane(
                first = {
                    EditContent(
                        text = text,
                        onBodyValueChange = onBodyValueChange,
                        onClickedTextButton = onClickedTextButton
                    )
                },
                second = {
                    NoteContent(noteBody = text)
                },
                strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 0.dp),
                displayFeatures = displayFeatures
            )
        }
    } else {
        EditSinglePaneScreen(
            modifier = modifier.fillMaxSize(),
            title = title,
            text = text,
            onBodyValueChange = onBodyValueChange,
            isEditModeEnabled = isEditModeEnabled,
            onModeChanged = onModeChanged,
            onSavedNote = onSavedNote,
            onClickedTextButton = onClickedTextButton,
            onBackPressed = onBackPressed,
            onClickTitle = onClickTitle
        )
    }
}