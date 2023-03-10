package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberDialogState
import com.yorick.sharednotes.ui.edit.EditViewModel

@Composable
actual fun SaveNoteAlertDialog(
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
) {
    SharedNotesDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = "Not saved",
        text = {
            Text(
                text = "Do you really want to exit the Editor?",
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = "Cancel")
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Confirm")
            }
        },
        size = DpSize(360.dp, 180.dp),
        onConfirm = onConfirm,
    )
}

@Composable
actual fun NewNoteAlertDialog(
    editViewModel: EditViewModel,
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    onSubjectValueChange: (String) -> Unit,
    title: String,
    categories: List<String>,
    tags: List<String>,
    titleEditorFocus: FocusRequester,
) {
    SharedNotesDialog(
        onDismissRequest = onDismissRequest,
        title = "Note Info",
        text = {
            OutlinedTextField(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .focusRequester(titleEditorFocus),
                value = editViewModel.noteSubject,
                onValueChange = { editViewModel.noteSubject = it },
                label = { Text(text = "Note Info") },
                singleLine = true
            )
            SharedNotesDropDownMenu(
                menuList = categories,
                label = "Categories"
            )
            SharedNotesDropDownMenu(
                menuList = tags,
                label = "Tags"
            )
        },
        confirmButton = {
            TextButton(
                onClick = onConfirm
            ) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = "Cancel")
            }
        },
        onConfirm = onConfirm,
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SharedNotesDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    title: String,
    text: @Composable () -> Unit,
    confirmButton: @Composable () -> Unit = {},
    dismissButton: @Composable () -> Unit = {},
    size: DpSize = DpSize(360.dp, 420.dp),
) {
    Dialog(
        title = title,
        undecorated = true,
        transparent = true,
        onCloseRequest = onDismissRequest,
        state = rememberDialogState(
            position = WindowPosition(Alignment.Center),
            size = size
        ),
        resizable = false,
        onKeyEvent = { keyEvent ->
            when {
                (keyEvent.key == Key.Enter && keyEvent.type == KeyEventType.KeyUp)
                -> {
                    onConfirm()
                    true
                }

                (keyEvent.key == Key.Escape && keyEvent.type == KeyEventType.KeyUp) -> {
                    onDismissRequest()
                    true
                }

                else -> {
                    false
                }
            }
        }
    ) {
        Card(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            shape = MaterialTheme.shapes.extraLarge,
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary
            ),
            elevation = CardDefaults.cardElevation(6.dp),
        ) {
            Box {
                WindowDraggableArea(modifier.fillMaxSize())
                Column(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = modifier.fillMaxWidth()
                            .padding(top = 20.dp),
                    ) {
                        Text(
                            text = title,
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    Column(
                        modifier.fillMaxWidth().padding(top = 10.dp)
                    ) {
                        text()
                    }
                    Row(
                        modifier = modifier.fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        dismissButton()
                        Spacer(modifier.size(10.dp))
                        confirmButton()
                    }
                }
            }
        }
    }
}