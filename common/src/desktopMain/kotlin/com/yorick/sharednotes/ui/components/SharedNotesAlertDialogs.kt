package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberDialogState

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
        size = DpSize(360.dp, 200.dp)
    )
}

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
    SharedNotesDialog(
        onDismissRequest = onDismissRequest,
        title = "Note Info",
        text = {
            OutlinedTextField(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .focusRequester(titleEditorFocus),
                value = title,
                onValueChange = onSubjectValueChange,
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
    )
}

@Composable
fun SharedNotesDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
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
        resizable = false
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(10.dp).verticalScroll(rememberScrollState())
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = MaterialTheme.colorScheme.secondaryContainer
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 30.dp),
            ) {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Column(
                modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 30.dp)
            ) {
                text()
            }
            Row(
                modifier = modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 30.dp),
                horizontalArrangement = Arrangement.End
            ) {
                dismissButton()
                Spacer(modifier.size(10.dp))
                confirmButton()
            }
        }
    }
}