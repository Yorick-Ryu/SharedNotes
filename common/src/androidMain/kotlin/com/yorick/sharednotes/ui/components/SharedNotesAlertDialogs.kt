package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
actual fun SaveNoteAlertDialog(
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        title = { Text(text = "Not saved") },
        text = { Text(text = "Do you really want to exit the Editor?") },
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
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
actual fun NewNoteAlertDialog(
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    onSubjectValueChange: (String) -> Unit,
    title: String,
    categories: List<String>,
    tags: List<String>,
    titleEditorFocus: FocusRequester
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = "Note Info")
        },
        tonalElevation = 5.dp,
        text = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                SideEffect {
                    titleEditorFocus.requestFocus()
                }
                OutlinedTextField(
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .focusRequester(titleEditorFocus)
                        .onPreviewKeyEvent { keyEvent ->
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
                        },
                    value = title,
                    onValueChange = onSubjectValueChange,
                    label = { Text(text = "Note Title") },
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
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = "Cancel")
            }
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    )
}