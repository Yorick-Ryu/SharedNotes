package com.yorick.sharednotes.ui.screen

import androidx.compose.animation.*
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import com.yorick.sharednotes.ui.components.NewNoteAlertDialog
import com.yorick.sharednotes.ui.components.SaveNoteAlertDialog
import com.yorick.sharednotes.ui.components.SharedNotesTopBar
import com.yorick.sharednotes.ui.components.SharedNotesTwoPane
import com.yorick.sharednotes.ui.edit.EditContent
import com.yorick.sharednotes.ui.edit.EditSinglePaneScreen
import com.yorick.sharednotes.ui.note.NoteContent

@OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class)
@Composable
fun EditScreen(
    modifier: Modifier = Modifier,
    windowState: WindowState,
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
    AnimatedVisibility(
        visible = isOpenNoteInfoDialog,
        enter = scaleIn(),
        exit = scaleOut(),
    ) {
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
    AnimatedVisibility(isOpenSaveDialog) {
        SaveNoteAlertDialog(
            modifier = Modifier,
            onDismissRequest = onDismissSaveRequest,
            onConfirm = onConfirmClose,
        )
    }
    val isTwoPane: Boolean = windowState.size.width > 850.dp
    AnimatedVisibility(
        visible = isTwoPane,
        enter = expandHorizontally(initialWidth = { it / 2 }),
        exit = shrinkHorizontally(targetWidth = { it / 2 }) + fadeOut()
    ) {
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
            val noteStateVertical = rememberScrollState()
            val editStateVertical = rememberScrollState()
            SharedNotesTwoPane(
                modifier = Modifier.weight(1f),
                first = {
                    EditContent(
                        text = text,
                        onBodyValueChange = onBodyValueChange,
                        onClickedTextButton = onClickedTextButton,
                        stateVertical = editStateVertical
                    )
                    // TODO VerticalScrollbar
                },
                second = {
                    NoteContent(
                        noteBody = text,
                        stateVertical = noteStateVertical
                    )
                    VerticalScrollbar(
                        modifier = Modifier.align(Alignment.CenterEnd).padding(vertical = 10.dp)
                            .fillMaxHeight(),
                        adapter = rememberScrollbarAdapter(noteStateVertical)
                    )
                },
            )
        }
    }
    AnimatedVisibility(
        visible = !isTwoPane,
        enter = expandHorizontally(initialWidth = { it / 2 }),
        exit = shrinkHorizontally(targetWidth = { it / 2 })
    ) {
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